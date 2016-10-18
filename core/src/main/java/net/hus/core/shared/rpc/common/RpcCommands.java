package net.hus.core.shared.rpc.common;

public interface RpcCommands extends RpcCommand, RpcResponse
{
  RpcCommand[] getRpcCommands();

  void add(RpcResponse inRpcResponse);
}
