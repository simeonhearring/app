package net.hus.core.client.ui.common;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.shared.command.RequestCommand;
import net.hus.core.shared.model.Value;

public abstract class AbstractCommand_View<C extends Widget & HasClickHandlers>
    extends Abstract_View<C> implements ClickHandler
{
  private String mCommandName;

  public AbstractCommand_View(C inComponent, String inCommandName)
  {
    super(inComponent);
    mCommandName = inCommandName;
  }

  @Override
  public void addChangeHandler()
  {
    clearRegistration();
    add(mComponent.addClickHandler(this));
  }

  @Override
  public void setValue(Value inValue)
  {
  }

  @Override
  public void onClick(ClickEvent inEvent)
  {
    Global.fire(new RequestCommand(mCommandName, mFieldTKG), new RpcCallback<RequestCommand>()
    {
      @Override
      public void onRpcSuccess(RequestCommand inCommand)
      {
        EventLocater.fireEvent(inCommand.commandName(), inCommand.getData());
      }
    });
  }
}