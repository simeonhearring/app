package net.hus.core.server.command;

import net.hus.core.shared.command.RequestCommand;
import net.hus.core.shared.components.Response;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Profile;
import net.hus.core.shared.model.Values;
import net.hus.core.shared.rpc.common.RpcResponse;

public class LoginCommandBean extends AbstractCommandBean<RequestCommand>
{
  @Override
  public RpcResponse execute(RequestCommand inCommand)
  {
    Values values = new Values();
    values.setValues(mCoreDao.values().selectLast(inCommand.tkg()));

    String userName = values.get(Field.Fid.USERNAME).getValue();
    String password = values.get(Field.Fid.PASSWORD).getValue();

    Profile profile = mCoreDao.profile(userName);
    String authenticated = String.valueOf(profile.getPassword().equals(password));

    Response data = new Response();
    data.setData(authenticated, userName);

    inCommand.setData(data);

    return inCommand;
  }
}