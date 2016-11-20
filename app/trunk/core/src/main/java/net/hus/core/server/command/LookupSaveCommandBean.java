package net.hus.core.server.command;

import net.hus.core.shared.command.LookupSaveCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class LookupSaveCommandBean extends AbstractCommandBean<LookupSaveCommand>
{
  @Override
  public RpcResponse execute(LookupSaveCommand inCommand)
  {
    mCoreDao.lookups().upsert(inCommand.getLookups());
    return inCommand;
  }
}