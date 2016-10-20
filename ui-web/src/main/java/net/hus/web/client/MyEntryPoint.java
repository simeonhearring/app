package net.hus.web.client;

import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import net.hus.core.client.AbstractEntryPoint;
import net.hus.core.client.common.Global;
import net.hus.core.client.service.common.RpcCallback;
import net.hus.core.client.ui.event.LoadMainEvent;
import net.hus.core.shared.command.LoggerCommand;
import net.hus.core.shared.command.LoggerCommand.Level;

public class MyEntryPoint extends AbstractEntryPoint
{
  @Override
  public void dispatch(LoadMainEvent inEvent)
  {
    Notify.notify("Alert");
    Global.fire(new LoggerCommand(Level.DEBUG, ""), new RpcCallback<LoggerCommand>()
    {
      @Override
      public void onRpcSuccess(LoggerCommand inResult)
      {
        Notify.notify("Back");
      }
    });
  }
}