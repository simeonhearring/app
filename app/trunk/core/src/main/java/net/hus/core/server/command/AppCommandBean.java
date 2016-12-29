package net.hus.core.server.command;

import net.hus.core.shared.command.RequestCommand;
import net.hus.core.shared.components.Response;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Values;
import net.hus.core.shared.rpc.common.RpcResponse;

public class AppCommandBean extends AbstractCommandBean<RequestCommand>
{
  @Override
  public RpcResponse execute(RequestCommand inCommand)
  {
    Values values = new Values();
    values.setValues(mCoreDao.values().selectLast(inCommand.tkg()));

    String userName = values.value(Field.Fid.USERNAME);
    String app = values.get(Field.Fid.APP).getValue();

    // See EventLocater.java
    inCommand.setData(new Response(userName, app));

    return inCommand;
  }
}