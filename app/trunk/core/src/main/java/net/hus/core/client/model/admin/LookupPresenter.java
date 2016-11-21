package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.LookupDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.EventType;

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
        mDisplay.addValues(inData.getLookupGroup());
        break;
      }
      case LOOKUP:
        mDisplay.addValues(inData.getLookupGroup());
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
}