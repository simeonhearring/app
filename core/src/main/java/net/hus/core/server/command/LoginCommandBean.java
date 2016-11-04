package net.hus.core.server.command;

import net.hus.core.model.Field;
import net.hus.core.model.Profile;
import net.hus.core.model.TableFvk;
import net.hus.core.model.Values;
import net.hus.core.shared.command.RequestCommand;
import net.hus.core.shared.model.Response;
import net.hus.core.shared.rpc.common.RpcResponse;

public class LoginCommandBean extends AbstractCommandBean<RequestCommand>
{
  @Override
  public RpcResponse execute(RequestCommand inCommand)
  {
    Values values = new Values();
    // String fvk = inCommand.fvk(); inCommand.get
    values.setValues(mCoreDao.values().selectLast(new TableFvk("LOGIN", "3", "LOGIN")));

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