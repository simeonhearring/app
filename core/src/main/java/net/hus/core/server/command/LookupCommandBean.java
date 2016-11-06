package net.hus.core.server.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.hus.core.shared.command.LookupCommand;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookups;
import net.hus.core.shared.rpc.common.RpcResponse;

public class LookupCommandBean extends AbstractCommandBean<LookupCommand>
{
  @Override
  public RpcResponse execute(LookupCommand inCommand)
  {
    Lookups data = new Lookups();

    for (Entry<String, String[]> value : inCommand.getMap().entrySet())
    {
      List<Lookup> lookups = new ArrayList<>();
      for (String group : value.getValue())
      {
        lookups.addAll(mCoreDao.lookups().select(group));
      }
      data.add(value.getKey(), lookups);
    }

    inCommand.setData(data);

    return inCommand;
  }
}