package net.hus.core.server.command;

import net.hus.core.shared.rpc.common.RpcCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

//import com.hus.gwttoolbox.shared.rpc.common.RpcCommand;
//import com.hus.gwttoolbox.shared.rpc.common.RpcResponse;

public interface CommandBean<C extends RpcCommand>
{
  RpcResponse execute(C inCommand);
}
