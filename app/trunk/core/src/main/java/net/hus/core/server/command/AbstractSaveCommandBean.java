package net.hus.core.server.command;

import net.hus.core.model.AbstractModel;
import net.hus.core.shared.command.AbstractSaveCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

//import com.hus.gwttoolbox.shared.command.AbstractSaveCommand;
//import com.hus.gwttoolbox.shared.model.AbstractModel;
//import com.hus.gwttoolbox.shared.rpc.common.RpcResponse;

public abstract class AbstractSaveCommandBean<M extends AbstractModel, C extends AbstractSaveCommand<M>>
extends AbstractCommandBean<C>
{
  C mCommand;

  @Override
  public RpcResponse execute(C inCommand)
  {
    mCommand = inCommand;

    for (M value : inCommand.getInsert())
    {
      insert(value);
    }

    for (M value : inCommand.getUpdate())
    {
      update(value);
    }

    for (M value : inCommand.getDelete())
    {
      delete(value);
    }

    return inCommand;
  }

  public void update(M inModel)
  {
    // default - do nothing
  }

  public void insert(M inModel)
  {
    // default - do nothing
  }

  public void delete(M inModel)
  {
    // default - do nothing
  }
}