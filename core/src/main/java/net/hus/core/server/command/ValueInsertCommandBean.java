package net.hus.core.server.command;

import net.hus.core.shared.command.ValueInsertCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class ValueInsertCommandBean extends AbstractCommandBean<ValueInsertCommand>
{
  @Override
  public RpcResponse execute(ValueInsertCommand inCommand)
  {
    mCoreDao.values().insert(inCommand.getValues());
    return inCommand;
  }
}