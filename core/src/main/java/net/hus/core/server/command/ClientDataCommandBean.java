package net.hus.core.server.command;

import net.hus.core.shared.command.ClientDataCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class ClientDataCommandBean extends AbstractCommandBean<ClientDataCommand>
{
  @Override
  public RpcResponse execute(ClientDataCommand inCommand)
  {
    inCommand.setData(inCommand.getIpAddress());
    return inCommand;
  }
}