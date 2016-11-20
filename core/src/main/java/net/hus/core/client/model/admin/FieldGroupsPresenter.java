package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.FieldGroupsDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.FieldsDataCommand;
import net.hus.core.shared.command.FieldsDataCommand.Type;
import net.hus.core.shared.command.LookupSaveCommand;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.util.RandomUtil;

public class FieldGroupsPresenter extends RpcCallback<FieldsDataCommand> implements Action
{
  private FieldGroupsDisplay mDisplay;

  public FieldGroupsPresenter(FieldGroupsDisplay inDisplay)
  {
    mDisplay = inDisplay;
    mDisplay.setAction(this);

    refresh();
  }

  private void refresh()
  {
    Global.fire(new FieldsDataCommand(Type.GROUPS), this);
  }

  @Override
  public void onRpcSuccess(FieldsDataCommand inCommand)
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
      {
        mDisplay.addFieldGroup(inCommand.getData().getFieldGroup());
        break;
      }
      default:
        break;
    }
  }

  @Override
  public void select(String inGroup, String inDisplay, Long inId)
  {
    mDisplay.setGroupName(inGroup, inDisplay);
    Global.fire(new FieldsDataCommand(Type.GROUP, inGroup), this);
  }

  @Override
  public void addGroup(final String inGroup)
  {
    final String name = RandomUtil.random(7);

    Lookup lookup = new Lookup();
    lookup.setGroup(Group.FIELD_GROUP);
    lookup.setName(name);
    lookup.setDisplay(inGroup);
    lookup.setSort(0);

    Global.fire(new LookupSaveCommand(lookup), new RpcCallback<LookupSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + inGroup);
        refresh();
        select(name, inGroup, null); // consolidate
      }
    });
  }
}