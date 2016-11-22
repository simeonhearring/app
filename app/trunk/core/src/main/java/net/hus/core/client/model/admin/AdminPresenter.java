package net.hus.core.client.model.admin;

import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.model.EventType;

public class AdminPresenter extends RpcCallback<AdminDataCommand> implements AdminEvent.Handler
{
  private AdminDisplay mDisplay;

  public AdminPresenter(AdminDisplay inDisplay)
  {
    Global.addHandler(AdminEvent.TYPE, this);
    mDisplay = inDisplay;

    new FieldPresenter(mDisplay.getField());
    new FieldsPresenter(mDisplay.getFields());
    new LookupPresenter(mDisplay.getLookup());

    Global.fire(new AdminDataCommand(EventType.ALL), this);
  }

  @Override
  public void onRpcSuccess(AdminDataCommand inCommand)
  {
    Global.fire(new AdminEvent(inCommand.getType(), inCommand.getData()));
  }

  public AdminDisplay getDisplay()
  {
    return mDisplay;
  }

  @Override
  public void dispatch(AdminEvent inEvent)
  {
    switch (inEvent.getType())
    {
      case REFRESH:
        Global.fire(new AdminDataCommand(EventType.ALL), this);
        break;
      default:
        break;
    }
  }
}