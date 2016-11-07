package net.hus.core.client.ui.event;

import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;

public class AlertEvent extends Event<AlertEvent.Handler>
{
  public interface Handler extends EventHandler
  {
    void dispatch(AlertEvent inEvent);
  }

  public static final Type<Handler> TYPE = new Type<>();

  private final NotifyType mType;
  private final String mMessage;

  public AlertEvent(NotifyType inType, String inMessage)
  {
    mType = inType;
    mMessage = inMessage;
  }

  @Override
  public Type<Handler> getAssociatedType()
  {
    return TYPE;
  }

  @Override
  protected void dispatch(Handler inHandler)
  {
    inHandler.dispatch(this);
  }

  public NotifyType getType()
  {
    return mType;
  }

  public String getMessage()
  {
    return mMessage;
  }
}
