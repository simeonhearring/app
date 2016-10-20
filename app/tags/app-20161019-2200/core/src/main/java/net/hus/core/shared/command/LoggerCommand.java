package net.hus.core.shared.command;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hus.core.shared.rpc.CommandName;
import net.hus.core.shared.rpc.common.RpcResponse;

@SuppressWarnings("serial")
@CommandName("LoggerCommand")
public class LoggerCommand extends AbstractCommand implements AsyncCallback<RpcResponse>
{
  public enum Level
  {
    DEBUG,
    INFO,
    WARN,
    ERROR,
    FATAL
  }

  private Level mLevel;
  private String mMessage;
  private Throwable mThrowable;

  LoggerCommand()
  {
  }

  public LoggerCommand(Level inLevel, String inMessage)
  {
    mLevel = inLevel;
    mMessage = inMessage;
  }

  public LoggerCommand(Level inLevel, String inMessage, Throwable inThrowable)
  {
    mLevel = inLevel;
    mMessage = inMessage;
    mThrowable = inThrowable;
  }

  public Level getLevel()
  {
    return mLevel;
  }

  public String getMessage()
  {
    return mMessage;
  }

  @Override
  public boolean isEncryptRequired()
  {
    return false;
  }

  public Throwable getThrowable()
  {
    return mThrowable;
  }

  @Override
  public void onFailure(Throwable inCaught)
  {
    // do nothing
  }

  @Override
  public void onSuccess(RpcResponse inResult)
  {
    // do nothing
  }
}