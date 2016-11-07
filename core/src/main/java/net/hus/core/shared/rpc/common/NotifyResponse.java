package net.hus.core.shared.rpc.common;

import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;

@SuppressWarnings("serial")
public class NotifyResponse implements RpcResponse
{
  private NotifyType mType;
  private String mMessage;

  NotifyResponse()
  {
  }

  public NotifyResponse(String inMessage)
  {
    this(NotifyType.INFO, inMessage);
  }

  public NotifyResponse(NotifyType inType, String inMessage)
  {
    mType = inType;
    mMessage = inMessage;
  }

  public String getMessage()
  {
    return mMessage;
  }

  public NotifyType getType()
  {
    return mType;
  }
}