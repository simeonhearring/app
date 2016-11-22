package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.LookupDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.command.LookupSaveCommand;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.EventType;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookup.Group;

public class LookupPresenter extends RpcCallback<AdminDataCommand>
    implements Action, AdminEvent.Handler
{
  private LookupDisplay mDisplay;

  public LookupPresenter(LookupDisplay inDisplay)
  {
    Global.addHandler(AdminEvent.TYPE, this);
    mDisplay = inDisplay;
    mDisplay.setAction(this);
  }

  @Override
  public void dispatch(AdminEvent inEvent)
  {
    process(inEvent.getType(), inEvent.getData());
  }

  @Override
  public void onRpcSuccess(AdminDataCommand inCommand)
  {
    process(inCommand.getType(), inCommand.getData());
  }

  private void process(EventType inType, AdminData inData)
  {
    switch (inType)
    {
      case ALL:
      {
        mDisplay.addLookupGroups(inData.getLookupGroups());
        mDisplay.addValues(inData.getLookups());
        break;
      }
      case LOOKUP:
        mDisplay.addValues(inData.getLookups());
        break;
      default:
        break;
    }
  }

  @Override
  public void select(String inGroup)
  {
    Global.fire(new AdminDataCommand(inGroup, EventType.LOOKUP), this);
  }

  @Override
  public void createLookup(final String inName)
  {
    Lookup lookup = new Lookup();
    lookup.setGroup(Group.LOOKUP);
    lookup.setName(Field.officialName(inName));

    lookup.setAltId(null);
    lookup.setDisplay(inName);
    lookup.setSort(0);

    Global.fire(new LookupSaveCommand(lookup), new RpcCallback<LookupSaveCommand>()
    {
      @Override
      public void onRpcSuccess(LookupSaveCommand inCommand)
      {
        mDisplay.notify("Saved ... " + inName);
        mDisplay.reset();
        Global.fire(new AdminEvent(EventType.REFRESH, null));
      }
    });
  }
}