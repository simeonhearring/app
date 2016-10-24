package net.hus.core.shared.command;

import java.util.HashMap;
import java.util.Map;

import net.hus.core.model.Lookups;
import net.hus.core.shared.rpc.CommandName;

@CommandName("LookupCommand")
public class LookupCommand extends AbstractDataCommand<Lookups>
{
  private static final long serialVersionUID = -414352655539735974L;

  private Map<String, String[]> mMap = new HashMap<>();

  public LookupCommand()
  {
  }

  public LookupCommand(String inKey, String... inLookupGroup)
  {
    add(inKey, inLookupGroup);
  }

  public void add(String inKey, String... inLookupGroup)
  {
    mMap.put(inKey, inLookupGroup);
  }

  public Map<String, String[]> getMap()
  {
    return mMap;
  }
}