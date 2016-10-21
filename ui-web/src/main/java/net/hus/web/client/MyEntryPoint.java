package net.hus.web.client;

import org.gwtbootstrap3.client.ui.Badge;

import com.google.gwt.user.client.ui.RootPanel;

import net.hus.core.client.AbstractEntryPoint;
import net.hus.core.client.common.Global;
import net.hus.core.client.service.common.RpcCallback;
import net.hus.core.client.ui.Badge_;
import net.hus.core.client.ui.Convert;
import net.hus.core.client.ui.event.LoadMainEvent;
import net.hus.core.shared.command.UIObjectCommand;

public class MyEntryPoint extends AbstractEntryPoint
{
  @Override
  public void dispatch(LoadMainEvent inEvent)
  {
    Badge badge = new Badge("Hello");

    RootPanel.get().add(badge);

    Global.fire(new UIObjectCommand<Badge_>(), new RpcCallback<UIObjectCommand<Badge_>>()
    {
      @Override
      public void onRpcSuccess(UIObjectCommand<Badge_> inResult)
      {
        Badge uiobject = new Convert().convert(inResult.getUIObject());

        RootPanel.get().add(uiobject);
      }
    });
  }
}