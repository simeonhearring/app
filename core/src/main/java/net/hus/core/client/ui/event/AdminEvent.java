package net.hus.core.client.ui.event;

import net.hus.core.shared.model.AdminData;
import net.hus.core.shared.model.EventType;

public class AdminEvent extends Event<AdminEvent.Handler>
{
  public interface Handler extends EventHandler
  {
    void dispatch(AdminEvent inEvent);
  }

  public static final Type<Handler> TYPE = new Type<>();

  private final EventType mType;
  private final AdminData mData;

  public AdminEvent(EventType inType, AdminData inData)
  {
    mType = inType;
    mData = inData;
  }

  public EventType getType()
  {
    return mType;
  }

  public AdminData getData()
  {
    return mData;
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