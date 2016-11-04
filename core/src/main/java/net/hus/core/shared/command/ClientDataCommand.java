package net.hus.core.shared.command;

import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hus.core.client.ui.common.Global;
import net.hus.core.shared.rpc.CommandName;

@SuppressWarnings("serial")
@CommandName("ClientDataCommand")
public class ClientDataCommand extends AbstractDataCommand<String>
implements AsyncCallback<ClientDataCommand>
{
  @Override
  public void onFailure(Throwable inCaught)
  {
  }

  @Override
  public void onSuccess(ClientDataCommand inCommand)
  {
    Global.setIpAddress(inCommand.getData());
    Notify.notify(Global.getIpAddress());
  }
}