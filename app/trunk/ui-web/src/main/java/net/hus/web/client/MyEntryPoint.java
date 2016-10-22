package net.hus.web.client;

import org.gwtbootstrap3.client.ui.Container;

import com.google.gwt.user.client.ui.RootPanel;

import net.hus.core.client.AbstractEntryPoint;
import net.hus.core.client.common.Global;
import net.hus.core.client.service.common.RpcCallback;
import net.hus.core.client.ui.Container_;
import net.hus.core.client.ui.Convert;
import net.hus.core.client.ui.event.LoadMainEvent;
import net.hus.core.shared.command.UIObjectCommand;

public class MyEntryPoint extends AbstractEntryPoint
{
  @Override
  public void dispatch(LoadMainEvent inEvent)
  {
    Global.fire(new UIObjectCommand<Container_>(), new RpcCallback<UIObjectCommand<Container_>>()
    {
      @Override
      public void onRpcSuccess(UIObjectCommand<Container_> inResult)
      {
        Convert convert = new Convert();

        Container_ uiObject_ = inResult.getUIObject();

        Container uiObject = convert.convert(uiObject_);

        RootPanel.get().add(uiObject);
      }
    });
  }
}