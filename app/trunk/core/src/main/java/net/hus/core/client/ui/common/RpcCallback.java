package net.hus.core.client.ui.common;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hus.core.client.ui.event.AlertEvent;
import net.hus.core.shared.command.LoggerCommand;
import net.hus.core.shared.command.LoggerCommand.Level;
import net.hus.core.shared.rpc.common.NotifyResponse;

public abstract class RpcCallback<T> implements AsyncCallback<T>
{
  public abstract void onRpcSuccess(T inResult);

  public void onNotify(NotifyResponse inResponse)
  {
    Global.fireEvent(new AlertEvent(inResponse.getNotifyMessage()));
  }

  @Override
  public void onFailure(Throwable inCaught)
  {
    LoggerCommand command = new LoggerCommand(Level.ERROR, "RPC FAILURE", inCaught);
    Global.fire(command, command);
  }

  @Override
  public void onSuccess(T inResult)
  {
    if (inResult instanceof NotifyResponse)
    {
      onNotify((NotifyResponse) inResult);
    }
    else
    {
      onRpcSuccess(inResult);
    }
  }
}