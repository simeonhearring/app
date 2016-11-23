package net.hus.core.shared.command;

import net.hus.core.shared.model.LookupXL;
import net.hus.core.shared.rpc.CommandName;

@CommandName("LookupXLSaveCommand")
public class LookupXLSaveCommand extends AbstractCommand
{
  private static final long serialVersionUID = 3473507493025658823L;

  private LookupXL mLookup;

  LookupXLSaveCommand()
  {
  }

  public LookupXLSaveCommand(LookupXL inLookup)
  {
    mLookup = inLookup;
  }

  public LookupXL getLookup()
  {
    return mLookup;
  }
}