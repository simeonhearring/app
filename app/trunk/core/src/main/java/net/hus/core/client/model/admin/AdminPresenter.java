package net.hus.core.client.model.admin;

import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.FieldsDataCommand;

public class AdminPresenter extends RpcCallback<FieldsDataCommand>
{
  private AdminDisplay mDisplay;

  public AdminPresenter(AdminDisplay inDisplay)
  {
    mDisplay = inDisplay;

    new FieldsPresenter(mDisplay.getFields());
    new FieldGroupsPresenter(mDisplay.getGroups());
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