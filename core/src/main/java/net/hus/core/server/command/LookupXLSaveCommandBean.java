package net.hus.core.server.command;

import net.hus.core.shared.command.LookupXLSaveCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class LookupXLSaveCommandBean extends AbstractCommandBean<LookupXLSaveCommand>
{
  @Override
  public RpcResponse execute(LookupXLSaveCommand inCommand)
  {
    mCoreDao.upsertXL(inCommand.getLookup());
    return inCommand;
  }
}