package net.hus.core.server.command;

import net.hus.core.shared.command.ProfileCommand;
import net.hus.core.shared.model.Profile;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.shared.util.RandomUtil;

public class ProfileCommandBean extends AbstractCommandBean<ProfileCommand>
{
  @Override
  public RpcResponse execute(ProfileCommand inCommand)
  {
    Profile profile = mCoreDao.profile(inCommand.getUserName());
    profile.setPassword(null);

    if (inCommand.isLogin())
    {
      profile.setFvk(inCommand.getIpAddress() + "." + RandomUtil.random(5));
    }

    inCommand.setData(profile);

    return inCommand;
  }
}