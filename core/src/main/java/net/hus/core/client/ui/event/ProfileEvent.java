package net.hus.core.client.ui.event;

import net.hus.core.shared.model.Profile.Code;

public class ProfileEvent extends Event<ProfileEvent.Handler>
{
  public interface Handler extends EventHandler
  {
    void dispatch(ProfileEvent inEvent);
  }

  public static final Type<Handler> TYPE = new Type<>();

  private final String mName;

  public ProfileEvent(String inName)
  {
    mName = inName;
  }

  public ProfileEvent(Code inName)
  {
    this(inName.name());
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

  public String getName()
  {
    return mName;
  }
}