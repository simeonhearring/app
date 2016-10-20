package net.hus.core.shared.rpc.common;

public interface RpcResponseHandler<T extends RpcResponse>
{
  void handle(T inRpcResponse);
}
