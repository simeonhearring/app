package net.hus.core.server.command;

import net.hus.core.model.Field;
import net.hus.core.model.Profile;
import net.hus.core.model.FieldTKG;
import net.hus.core.model.Values;
import net.hus.core.shared.command.RequestCommand;
import net.hus.core.shared.components.Response;
import net.hus.core.shared.rpc.common.RpcResponse;

public class LoginCommandBean extends AbstractCommandBean<RequestCommand>
{
  @Override
  public RpcResponse execute(RequestCommand inCommand)
  {
    Values values = new Values();
    FieldTKG fvk = inCommand.fvk();
    values.setValues(mCoreDao.values().selectLast(fvk));//new FieldTKG("LOGIN", "3", "LOGIN")));

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