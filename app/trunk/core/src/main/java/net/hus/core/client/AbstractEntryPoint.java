package net.hus.core.client;

import java.util.Date;
import java.util.Map;

import org.gwtbootstrap3.extras.notify.client.ui.Notify;
import org.gwtbootstrap3.extras.notify.client.ui.NotifySettings;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hus.core.client.service.rpc.RpcService;
import net.hus.core.client.service.rpc.RpcServiceAsync;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.event.AlertEvent;
import net.hus.core.client.ui.event.CssChangeEvent;
import net.hus.core.client.ui.event.LoadMainEvent;
import net.hus.core.client.ui.event.ReportEvent;
import net.hus.core.client.ui.service.bus.GwtEventBus;
import net.hus.core.shared.command.ClientDataCommand;
import net.hus.core.shared.command.LoggerCommand.Level;
import net.hus.core.shared.util.EncryptUtil;
import net.hus.core.shared.util.EntryPointUtil;
import net.hus.core.shared.util.JsniUtil;

public abstract class AbstractEntryPoint implements EntryPoint, AlertEvent.Handler,
ReportEvent.Handler, LoadMainEvent.Handler, CssChangeEvent.Handler,
AsyncCallback<ClientDataCommand>
{
  @Override
  public void onModuleLoad()
  {
    GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler()
    {
      @Override
      public void onUncaughtException(Throwable inE)
      {
        Window.alert(
            "Opps!  We did not process your request correctly.  Please report this by using 'Contact Us'.  (How embarrassing!)");
        Global.logError("UNCAUGHT EXCEPTION", inE);
      }
    });
    Global.setRpcService((RpcServiceAsync) GWT.create(RpcService.class));
    Global.log(Level.INFO, "Started...", null);
    Global.setEventBus(new GwtEventBus());
    Global.addHandler(AlertEvent.TYPE, this);
    Global.addHandler(ReportEvent.TYPE, this);
    Global.addHandler(LoadMainEvent.TYPE, this);
    Global.addHandler(CssChangeEvent.TYPE, this);

    Global.fire(new ClientDataCommand(), this);

    Global.fireEvent(new LoadMainEvent());
  }

  @Override
  public void dispatch(AlertEvent inEvent)
  {
    Notify.notify(inEvent.getMessage(), inEvent.getType());
  }

  @Override
  public void dispatch(ReportEvent inEvent)
  {
    String params =
        EncryptUtil.encrypt(inEvent.getName() + "&date=" + new Date().getTime() + getEncrypt());
    String url = GWT.getHostPageBaseURL() + "report?params=" + params;
    Window.open(url, "_blank", null);
  }

  public String getEncrypt()
  {
    return "";
  }

  public static Map<String, String> urlAsMap()
  {
    Map<String, String> ret = EntryPointUtil.convert(JsniUtil.getUrl());
    JsniUtil.unescape(ret);
    return ret;
  }

  @Override
  public void onFailure(Throwable inCaught)
  {
  }

  @Override
  public void onSuccess(ClientDataCommand inCommand)
  {
    Global.setIpAddress(inCommand.getData());
    NotifySettings settings = NotifySettings.newSettings();
    settings.setAllowDismiss(true);
    settings.setOffset(200, 140);
    Notify.notify(Global.getIpAddress(), settings);
  }

  @Override
  public void dispatch(CssChangeEvent inEvent)
  {
    NodeList<Element> links =
        Document.get().getElementsByTagName("head").getItem(0).getElementsByTagName("link");

    for (int i = 0; i < links.getLength(); i++)
    {
      Element link = links.getItem(i);

      String attr = link.getAttribute("href");
      int start = attr.indexOf("dcss/");
      if (start != -1)
      {
        String newCss = null;
        if (inEvent.isExternal())
        {
          newCss = inEvent.getCssFileName() + ".css";
        }
        else
        {
          newCss = attr.substring(0, start + 5) + inEvent.getCssFileName();
        }
        link.setAttribute("href", newCss);
        Notify.notify("Changing theme!");
      }
    }
  }
}