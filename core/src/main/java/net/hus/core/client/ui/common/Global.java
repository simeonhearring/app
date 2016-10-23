package net.hus.core.client.ui.common;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hus.core.client.common.User;
import net.hus.core.client.service.bus.EventBus;
import net.hus.core.client.service.rpc.RpcServiceAsync;
import net.hus.core.shared.command.LoggerCommand;
import net.hus.core.shared.command.LoggerCommand.Level;
import net.hus.core.shared.rpc.common.RpcCommand;
import net.hus.core.shared.rpc.common.RpcCommands;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.shared.util.StorageUtil;

public class Global
{
  private static final Global INSTANCE = new Global();

  private String mNumber;

  private EventBus mEventBus;

  private RpcServiceAsync mRpcService;

  private User mUser;

  private boolean mExpired;

  public static Global get()
  {
    return INSTANCE;
  }

  public static User getUser()
  {
    return INSTANCE.mUser;
  }

  public static String locale()
  {
    LocaleInfo l = LocaleInfo.getCurrentLocale();
    return l.getLocaleName();
  }

  public static boolean isUser()
  {
    return INSTANCE.mUser != null;
  }

  public static boolean isUser(String inEmail)
  {
    return INSTANCE.mUser != null && INSTANCE.mUser.getUserId() != null
        && INSTANCE.mUser.getUserId().equals(inEmail);
  }

  public static boolean isExpired()
  {
    return INSTANCE.mExpired;
  }

  public static void setExpired(boolean inExpired)
  {
    INSTANCE.mExpired = inExpired;
  }

  public static void setUser(User inUser)
  {
    INSTANCE.mUser = inUser;
  }

  public static void setEventBus(EventBus inEventBus)
  {
    INSTANCE.mEventBus = inEventBus;
  }

  public static void setRpcService(RpcServiceAsync inRpcServiceAsync)
  {
    INSTANCE.mRpcService = inRpcServiceAsync;
  }

  public static <H extends EventHandler> HandlerRegistration addHandler(Type<H> inType, H inHandler)
  {
    return INSTANCE.mEventBus.addHandler(inType, inHandler);
  }

  public static void fireEvent(GwtEvent<?> inEvent)
  {
    INSTANCE.mEventBus.fireEvent(inEvent);
  }

  public static void fire(GwtEvent<?> inEvent)
  {
    INSTANCE.mEventBus.fire(inEvent);
  }

  public static void logError(String inMessage, Throwable inCaught)
  {
    log(Level.ERROR, inMessage, inCaught);
  }

  public static void log(Level inLevel, String inMessage)
  {
    log(inLevel, inMessage, null);
  }

  public static void log(Level inLevel, String inMessage, Throwable inCaught)
  {
    LoggerCommand command = new LoggerCommand(inLevel, inMessage, inCaught);
    fire(command, command);
  }

  public static void setNumber(String inNumber)
  {
    INSTANCE.mNumber = inNumber;
  }

  public static String getEncryptKey()
  {
    return StorageUtil.getEncryptKey(INSTANCE.mNumber);
  }

  public static <C extends RpcCommand, R extends RpcResponse> void fire(C inCommand,
      AsyncCallback<R> inCallback)
  {
    initCommand(inCommand);
    RpcServiceAsync rpcService = INSTANCE.mRpcService;
    rpcService.fire(inCommand, inCallback);
  }

  public static <C extends RpcCommands, R extends RpcResponse> void fire(C inCommand,
      AsyncCallback<R> inCallback)
  {
    for (RpcCommand command : inCommand.getRpcCommands())
    {
      initCommand(command);
    }

    RpcServiceAsync rpcService = INSTANCE.mRpcService;
    rpcService.fire(inCommand, inCallback);
  }

  private static <C extends RpcCommand> void initCommand(C inCommand)
  {
    if (INSTANCE.mUser != null)
    {
      inCommand.setUserInfo(INSTANCE.mUser.getUserId() + " " + INSTANCE.mUser.getUserName());
    }
    if (inCommand.isEncryptRequired())
    {
      inCommand.setEncryptKey(getEncryptKey());
      inCommand.encrypt();
    }
  }

  public static String getNumber()
  {
    return INSTANCE.mNumber;
  }
}
