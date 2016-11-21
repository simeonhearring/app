package net.hus.core.client.model.admin;

import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.FieldsDataCommand;
import net.hus.core.shared.model.EventType;

public class AdminPresenter extends RpcCallback<FieldsDataCommand>
{
  private AdminDisplay mDisplay;

  public AdminPresenter(AdminDisplay inDisplay)
  {
    mDisplay = inDisplay;

    new FieldPresenter(mDisplay.getField());
    new FieldsPresenter(mDisplay.getFields());

    Global.fire(new FieldsDataCommand(EventType.GROUPS), this);
  }

  @Override
  public void onRpcSuccess(FieldsDataCommand inCommand)
  {
  }

  public AdminDisplay getDisplay()
  {
    return mDisplay;
  }
}