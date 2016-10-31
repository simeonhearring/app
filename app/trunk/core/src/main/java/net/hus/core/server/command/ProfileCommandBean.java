package net.hus.core.server.command;

import net.hus.core.model.Lookup;
import net.hus.core.model.Lookup.Group;
import net.hus.core.model.Profile;
import net.hus.core.parser.ProfileParser;
import net.hus.core.shared.command.ProfileCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class ProfileCommandBean extends AbstractCommandBean<ProfileCommand>
{
  @Override
  public RpcResponse execute(ProfileCommand inCommand)
  {
    Lookup lookup = mCoreDao.lookups().selectXL(Group.PROFILE, inCommand.getUserName());

    ProfileParser parser = new ProfileParser();
    Profile profile = parser.fromXml(lookup.getXL());
    profile.setPassword(null);

    inCommand.setData(profile);

    return inCommand;
  }
}