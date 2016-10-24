package net.hus.core.server.command;

import net.hus.core.dao.CoreDao;
import net.hus.core.shared.rpc.common.RpcCommand;

public abstract class AbstractCommandBean<C extends RpcCommand> implements CommandBean<C>
{
  protected CoreDao mCoreDao;

  public void setCoreDao(CoreDao inDao)
  {
    mCoreDao = inDao;
  }
}