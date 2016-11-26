package net.hus.core.shared.command;

import net.hus.core.shared.model.ComponentsQuery;
import net.hus.core.shared.model.Profile;
import net.hus.core.shared.rpc.CommandName;

@CommandName("ProfileCommand")
public class ProfileCommand extends AbstractDataCommand<ComponentsQuery>
{
  private static final long serialVersionUID = -927684964659115829L;

  private String mUserName;

  ProfileCommand()
  {
  }

  public ProfileCommand(String inUserName)
  {
    mUserName = inUserName;
  }

  public String getUserName()
  {
    return mUserName;
  }

  public boolean isLogin()
  {
    return Profile.UserName.login.name().equals(mUserName);
  }
}