package net.hus.core.client.model.admin;

import net.hus.core.client.model.admin.AdminDisplay.Action;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.FieldsDataCommand;

public class AdminPresenter extends RpcCallback<FieldsDataCommand> implements Action
{
  private AdminDisplay mDisplay;

  public AdminPresenter(AdminDisplay inDisplay)
  {
    mDisplay = inDisplay;
    mDisplay.setAction(this);

    new FieldsPresenter(mDisplay.getFields());
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