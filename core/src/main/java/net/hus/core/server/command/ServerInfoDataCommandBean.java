package net.hus.core.server.command;

import net.hus.core.shared.command.ServerInfoDataCommand;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.HostUtil;

public class ServerInfoDataCommandBean extends AbstractCommandBean<ServerInfoDataCommand>
{
  @Override
  public RpcResponse execute(ServerInfoDataCommand inCommand)
  {
    String serverInfo = HostUtil.getHostName();

    inCommand.setData("Hello, !<br><br>I am running " + serverInfo
        + ".<br><br>It looks like you are using:<br>");

    return inCommand;
  }
}
