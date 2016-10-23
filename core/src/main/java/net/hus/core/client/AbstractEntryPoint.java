package net.hus.core.client;

import java.util.Date;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.Window;

import net.hus.core.client.service.rpc.RpcService;
import net.hus.core.client.service.rpc.RpcServiceAsync;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.event.AlertEvent;
import net.hus.core.client.ui.event.LoadMainEvent;
import net.hus.core.client.ui.event.ReportEvent;
import net.hus.core.client.ui.service.bus.GwtEventBus;
import net.hus.core.shared.command.LoggerCommand.Level;
import net.hus.core.shared.util.EncryptUtil;
import net.hus.core.shared.util.EntryPointUtil;
import net.hus.core.shared.util.JsniUtil;

public abstract class AbstractEntryPoint implements EntryPoint, AlertEvent.Handler,
ReportEvent.Handler, LoadMainEvent.Handler
{
  @Override
  public void onModuleLoad()
  {
    GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler()
    {
      @Override
      public void onUncaughtException(Throwable inE)
      {
        Window
        .alert("Opps!  We did not process your request correctly.  Please report this by using 'Contact Us'.  (How embarrassing!)");
        Global.logError("UNCAUGHT EXCEPTION", inE);
      }
    });
    Global.setRpcService((RpcServiceAsync) GWT.create(RpcService.class));
    Global.log(Level.INFO, "Started...", null);
    Global.setEventBus(new GwtEventBus());
    Global.addHandler(AlertEvent.TYPE, this);
    Global.addHandler(ReportEvent.TYPE, this);
    Global.addHandler(LoadMainEvent.TYPE, this);
    Global.fireEvent(new LoadMainEvent());
  }

  @Override
  public void dispatch(AlertEvent inEvent)
  {
    Window.alert(inEvent.getMessage());
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
}