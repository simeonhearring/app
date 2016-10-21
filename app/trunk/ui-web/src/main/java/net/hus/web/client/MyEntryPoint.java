package net.hus.web.client;

import org.gwtbootstrap3.client.ui.FieldSet;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.constants.InputType;

import com.google.gwt.user.client.ui.RootPanel;

import net.hus.core.client.AbstractEntryPoint;
import net.hus.core.client.common.Global;
import net.hus.core.client.service.common.RpcCallback;
import net.hus.core.client.ui.Convert;
import net.hus.core.client.ui.FieldSet_;
import net.hus.core.client.ui.event.LoadMainEvent;
import net.hus.core.shared.command.UIObjectCommand;

public class MyEntryPoint extends AbstractEntryPoint
{
  @Override
  public void dispatch(LoadMainEvent inEvent)
  {
    Input input = new Input(InputType.TEXT);
    input.setValue("Hello");

    RootPanel.get().add(input);

    Global.fire(new UIObjectCommand<FieldSet_>(), new RpcCallback<UIObjectCommand<FieldSet_>>()
    {
      @Override
      public void onRpcSuccess(UIObjectCommand<FieldSet_> inResult)
      {
        Convert convert = new Convert();
        FieldSet_ uiObject_ = inResult.getUIObject();
        FieldSet uiObject = convert.convert(uiObject_);

        RootPanel.get().add(uiObject);
      }
    });
  }
}