package net.hus.core.client.ui;

import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.RequestCommand;
import net.hus.core.shared.rpc.HasCommandName;

public class AbstractCommand_View<C extends Widget & HasClickHandlers>
    extends Abstract_View<C, Void> implements ClickHandler, HasCommandName
{
  private String mCommandName;

  public AbstractCommand_View(String inKey, C inComponent, String inCommandName)
  {
    super(inKey, inComponent);
    mCommandName = inCommandName;
    mComponent.addClickHandler(this);
  }

  @Override
  public void setValue(Void inValue)
  {
  }

  @Override
  public void onClick(ClickEvent inEvent)
  {
    Notify.notify("I was clicked!!");
    Global.fire(new RequestCommand(commandName()), new RpcCallback<RequestCommand>()
    {
      @Override
      public void onRpcSuccess(RequestCommand inCommand)
      {
        Notify.notify("I'm back with ... " + inCommand.commandName());
      }
    });
  }

  @Override
  public String commandName()
  {
    return mCommandName;
  }
}