package net.hus.core.client.service.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hus.core.shared.rpc.common.RpcCommand;
import net.hus.core.shared.rpc.common.RpcCommands;
import net.hus.core.shared.rpc.common.RpcResponse;

public interface RpcServiceAsync
{
  <C extends RpcCommand, R extends RpcResponse> void fire(C inCommand,
      AsyncCallback<R> inCallback);

  <R extends RpcResponse> void fire(RpcCommands inCommand, AsyncCallback<R> inCallback);
}
