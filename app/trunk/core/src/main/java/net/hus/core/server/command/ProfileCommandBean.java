package net.hus.core.server.command;

import net.hus.core.model.Profile;
import net.hus.core.shared.command.ProfileCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class ProfileCommandBean extends AbstractCommandBean<ProfileCommand>
{
  @Override
  public RpcResponse execute(ProfileCommand inCommand)
  {
    if (inCommand.isApp())
    {
      inCommand.setData(mCoreDao.profile_app(inCommand.getUserName()));
    }
    else
    {
      Profile profile = mCoreDao.profile(inCommand.getUserName());
      profile.setPassword(null);
      inCommand.setData(profile);
    }
    return inCommand;
  }
}