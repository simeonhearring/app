package net.hus.core.shared.rpc.common;

@SuppressWarnings("serial")
public class NotifyResponse implements RpcResponse
{
  public enum Type
  {
    NO_ENCRYPT,
    DUPLICATE
  }

  private Type mNotifyType;
  private String mNotifyMessage;

  NotifyResponse()
  {
  }

  public NotifyResponse(Type inNotifyType, String inNotifyMessage)
  {
    mNotifyMessage = inNotifyMessage;
  }

  public String getNotifyMessage()
  {
    return mNotifyMessage;
  }

  public Type getNotifyType()
  {
    return mNotifyType;
  }
}