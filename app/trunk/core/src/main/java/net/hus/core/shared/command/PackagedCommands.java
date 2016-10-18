package net.hus.core.shared.command;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.shared.rpc.common.RpcCommand;
import net.hus.core.shared.rpc.common.RpcCommands;
import net.hus.core.shared.rpc.common.RpcResponse;


@SuppressWarnings("serial")
public class PackagedCommands extends AbstractCommand implements RpcCommands
{
  private RpcCommand[] mRpcCommands;
  private List<RpcResponse> mRpcResponses;

  PackagedCommands()
  {
  }

  @SafeVarargs
  public <C extends AbstractCommand> PackagedCommands(C... inRpcCommands)
  {
    mRpcCommands = inRpcCommands;
    mRpcResponses = new ArrayList<RpcResponse>();
  }

  @Override
  public RpcCommand[] getRpcCommands()
  {
    return mRpcCommands;
  }

  @Override
  public void add(RpcResponse inRpcResponse)
  {
    mRpcResponses.add(inRpcResponse);
  }

  public List<RpcResponse> getRpcResponses()
  {
    return mRpcResponses;
  }
}
