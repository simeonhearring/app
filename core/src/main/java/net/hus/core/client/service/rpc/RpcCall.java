package net.hus.core.client.service.rpc;

import com.google.gwt.event.shared.GwtEvent;

import net.hus.core.client.service.common.RpcCallback;
import net.hus.core.shared.rpc.common.RpcCommand;
import net.hus.core.shared.rpc.common.RpcCommands;
import net.hus.core.shared.rpc.common.RpcResponse;

public interface RpcCall
{
  <T extends RpcResponse, R extends RpcCallback<T>> void fireRpcCommand(RpcCommand inCommand,
      R inCallback);

  <T extends RpcResponse, R extends RpcCallback<T>> void fireRpcCommand(RpcCommands inCommand,
      R inCallback);

  void fire(GwtEvent<?> inEvent);
}