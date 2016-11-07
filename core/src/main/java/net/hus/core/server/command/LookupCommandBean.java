package net.hus.core.server.command;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.shared.command.LookupCommand;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookups;
import net.hus.core.shared.rpc.common.RpcResponse;

public class LookupCommandBean extends AbstractCommandBean<LookupCommand>
{
  @Override
  public RpcResponse execute(LookupCommand inCommand)
  {
    List<Lookup> list = new ArrayList<>();
    for (String value : inCommand.getLookupGroups())
    {
      list.addAll(mCoreDao.lookups().select(value));
    }

    Lookups data = new Lookups();
    data.setLookups(list);

    inCommand.setData(data);

    return inCommand;
  }
}