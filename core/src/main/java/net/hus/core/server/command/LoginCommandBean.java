package net.hus.core.server.command;

import net.hus.core.shared.command.RequestCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class LoginCommandBean extends AbstractCommandBean<RequestCommand>
{
  @Override
  public RpcResponse execute(RequestCommand inCommand)
  {
    return inCommand;
  }
}