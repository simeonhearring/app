package net.hus.core.client.model.admin;

import java.util.List;

import net.hus.core.client.model.admin.FieldsDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.command.FieldsSaveCommand;
import net.hus.core.shared.command.LookupSaveCommand;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.EventType;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.util.RandomUtil;

public class FieldsPresenter extends RpcCallback<AdminDataCommand>
    implements Action, AdminEvent.Handler
{
  private FieldsDisplay mDisplay;

  public FieldsPresenter(FieldsDisplay inDisplay)
  {
    Global.addHandler(AdminEvent.TYPE, this);
    mDisplay = inDisplay;
    mDisplay.setAction(this);
    refresh();
  }

  @Override
  public void dispatch(AdminEvent inEvent)
  {
  }

  @Override
  public void refresh()
  {
    mDisplay.reset();
    Global.fire(new AdminDataCommand(EventType.GROUPS), this);
  }

  @Override
  public void onRpcSuccess(AdminDataCommand inCommand)
  {
    switch (inCommand.getType())
    {
      case GROUPS:
      {
        mDisplay.addGroups(inCommand.getData().getFieldGroups());
        mDisplay.addFields(inCommand.getData().getFields());
        break;
      }
      case GROUP:
        mDisplay.selectFields(inCommand.getData().getFieldGroup());
        break;
      default:
        break;
    }
  }

  @Override
  public void select(String inFgg, String inName)
  {
    mDisplay.setGroupName(inFgg, inName);
    Global.fire(new AdminDataCommand(inFgg, EventType.GROUP), this);
  }

  @Override
  public void createGroup(String inName)
  {
    save(RandomUtil.random(7), inName);
  }

  @Override
  public void saveFields(String inFgg, final String inName, List<Long> inFieldIds)
  {
    Global.fire(new FieldsSaveCommand(inFgg, inFieldIds), new RpcCallback<FieldsSaveCommand>()
    {
      @Override
      public void onRpcSuccess(FieldsSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + inName);
      }
    });
  }

  @Override
  public void saveGroupName(String inFgg, final String inName)
  {
    save(inFgg, inName);
  }

  private void save(final String inFgg, final String inName)
  {
    Lookup lookup = new Lookup();
    lookup.setGroup(Group.FIELD_GROUP);
    lookup.setName(inFgg);
    lookup.setDisplay(inName);
    lookup.setSort(0);

    Global.fire(new LookupSaveCommand(lookup), new RpcCallback<LookupSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + inName);
        refresh();
        select(inFgg, inName); // consolidate refresh & select
      }
    });
  }
}