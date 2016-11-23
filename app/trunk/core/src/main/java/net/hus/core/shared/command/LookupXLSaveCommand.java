package net.hus.core.shared.command;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.rpc.CommandName;

@CommandName("LookupXLSaveCommand")
public class LookupXLSaveCommand extends AbstractCommand
{
  private static final long serialVersionUID = 3473507493025658823L;

  private List<Lookup> mLookups;

  LookupXLSaveCommand()
  {
  }

  public LookupXLSaveCommand(Lookup inLookup)
  {
    this(new ArrayList<Lookup>());
    mLookups.add(inLookup);
  }

  public LookupXLSaveCommand(List<Lookup> inLookups)
  {
    mLookups = inLookups;
  }

  public List<Lookup> getLookups()
  {
    return mLookups;
  }
}