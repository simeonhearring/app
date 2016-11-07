package net.hus.core.client.ui.common;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hus.core.client.ui.event.AlertEvent;
import net.hus.core.shared.command.LoggerCommand;
import net.hus.core.shared.command.LoggerCommand.Level;
import net.hus.core.shared.rpc.common.NotifyResponse;

public abstract class RpcCallback<T> implements AsyncCallback<T>
{
  public abstract void onRpcSuccess(T inCommand);

  public void onNotify(NotifyResponse inResponse)
  {
    Global.fireEvent(new AlertEvent(inResponse.getType(), inResponse.getMessage()));
  }

  @Override
  public void onFailure(Throwable inCaught)
  {
    LoggerCommand command = new LoggerCommand(Level.ERROR, "RPC FAILURE", inCaught);
    Global.fire(command, command);
  }

  @Override
  public void onSuccess(T inCommand)
  {
    if (inCommand instanceof NotifyResponse)
    {
      onNotify((NotifyResponse) inCommand);
    }
    else
    {
      onRpcSuccess(inCommand);
    }
  }
}