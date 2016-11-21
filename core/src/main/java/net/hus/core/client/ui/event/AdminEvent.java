package net.hus.core.client.ui.event;

import net.hus.core.shared.model.EventType;

public class AdminEvent extends Event<AdminEvent.Handler>
{
  public interface Handler extends EventHandler
  {
    void dispatch(AdminEvent inEvent);
  }

  public static final Type<Handler> TYPE = new Type<>();

  private EventType mType;

  public AdminEvent(EventType inType)
  {
    mType = inType;
  }

  public EventType getType()
  {
    return mType;
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
}