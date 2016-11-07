package net.hus.core.client.ui.components;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.main.EventLocater;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.RequestCommand;
import net.hus.core.shared.model.FieldTKG;

public class AbstractCommand_View<C extends Widget & HasClickHandlers>
    extends Abstract_View<C, Void> implements ClickHandler
{
  private String mCommandName;

  public AbstractCommand_View(C inComponent, String inCommandName)
  {
    super(inComponent);
    mCommandName = inCommandName;
  }

  @Override
  public void setFieldTKG(FieldTKG inTableFvk)
  {
    super.setFieldTKG(inTableFvk);
    mComponent.addClickHandler(this);
  }

  @Override
  public void setValue(Void inValue)
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