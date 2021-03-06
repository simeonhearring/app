package net.hus.core.shared.command;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.rpc.CommandName;

@CommandName("LookupSaveCommand")
public class LookupSaveCommand extends AbstractCommand
{
  private static final long serialVersionUID = 3473507493025658823L;

  private List<Lookup> mLookups;

  LookupSaveCommand()
  {
  }

  public LookupSaveCommand(Lookup... inLookup)
  {
    mLookups = new ArrayList<>();
    for (Lookup value : inLookup)
    {
      mLookups.add(value);
    }
  }

  public List<Lookup> getLookups()
  {
    return mLookups;
  }
}