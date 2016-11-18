package net.hus.core.server.command;

import net.hus.core.shared.command.FieldSaveCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class FieldSaveCommandBean extends AbstractCommandBean<FieldSaveCommand>
{
  @Override
  public RpcResponse execute(FieldSaveCommand inCommand)
  {
    mCoreDao.fields().upsert(inCommand.getField());
    mCoreDao.field2lookup();
    return inCommand;
  }
}