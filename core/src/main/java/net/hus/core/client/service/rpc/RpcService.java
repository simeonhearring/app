package net.hus.core.client.service.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import net.hus.core.shared.rpc.common.RpcCommand;
import net.hus.core.shared.rpc.common.RpcCommands;
import net.hus.core.shared.rpc.common.RpcResponse;

@RemoteServiceRelativePath("rpcservlet")
public interface RpcService extends RemoteService
{
  RpcResponse fire(RpcCommand inCommand);

  RpcResponse fire(RpcCommands inCommand);
}