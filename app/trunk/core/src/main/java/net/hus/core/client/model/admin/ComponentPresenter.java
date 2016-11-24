package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.ComponentDisplay.Action;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.client.ui.event.AdminEvent;
import net.hus.core.shared.command.AdminDataCommand;
import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.EventType;

public class ComponentPresenter extends RpcCallback<AdminDataCommand>
implements Action, AdminEvent.Handler
{
  private ComponentDisplay mDisplay;

  public ComponentPresenter(ComponentDisplay inDisplay)
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
        mDisplay.addTables(inData.getTables());
        mDisplay.addFieldGroups(inData.getFieldGroups());
        mDisplay.addPages(inData.getPages());
        break;
      }
      case PAGE:
        mDisplay.addPage(inData.getPage());
        break;
      default:
        break;
    }
  }

  @Override
  public void select(String inName)
  {
    Global.fire(new AdminDataCommand(inName, EventType.PAGE), this);
  }
}