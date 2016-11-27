package net.hus.core.client.ui.event;

import net.hus.core.shared.components.Response;
import net.hus.core.shared.model.Profile.UserName;

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

  public ProfileEvent(UserName inUserName)
  {
    this(inUserName.name());
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
}