package net.hus.core.client.ui.event;

import net.hus.core.shared.components.Response;

public class ProfileEvent extends Event<ProfileEvent.Handler>
{
  public interface Handler extends EventHandler
  {
    void dispatch(ProfileEvent inEvent);
  }

  public static final Type<Handler> TYPE = new Type<>();

  private final String mName;
  private final boolean mApp;

  public ProfileEvent(String inName)
  {
    mName = inName;
    mApp = false;
  }

  public ProfileEvent(Response inResponse)
  {
    // 0 See LoginCommandBean.java
    this(inResponse.getData()[0]);
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

  public boolean isApp()
  {
    return mApp;
  }
}