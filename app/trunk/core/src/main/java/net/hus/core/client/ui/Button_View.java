package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.model.TableKey;
import net.hus.core.shared.command.RequestCommand;

public class Button_View extends Abstract_View<Button, Void> implements ClickHandler
{
  public Button_View(String inKey, Button inComponent)
  {
    super(inKey, inComponent);
    mComponent.addClickHandler(this);
  }

  @Override
  public void setTableKey(TableKey inTableKey)
  {
    super.setTableKey(inTableKey);
  }

  @Override
  public void setValue(Void inValue)
  {
    // mComponent.setValue(inValue);
  }

  @Override
  public Widget asWidget()
  {
    return mComponent;
  }

  @Override
  public void onClick(ClickEvent inEvent)
  {
    Notify.notify("I was clicked!!");
    Global.fire(new RequestCommand("LoginCommand"), new RpcCallback<RequestCommand>()
    {
      @Override
      public void onRpcSuccess(RequestCommand inResult)
      {
      }
    });
  }
}