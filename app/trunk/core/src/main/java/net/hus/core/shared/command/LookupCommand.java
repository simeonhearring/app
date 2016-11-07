package net.hus.core.shared.command;

import net.hus.core.shared.model.Lookups;
import net.hus.core.shared.rpc.CommandName;

@CommandName("LookupCommand")
public class LookupCommand extends AbstractDataCommand<Lookups>
{
  private static final long serialVersionUID = -414352655539735974L;

  private String mSearchText;
  private String[] mLookupGroups;

  LookupCommand()
  {
  }

  public LookupCommand(String inSearchText, String... inLookupGroups)
  {
    mSearchText = inSearchText;
    mLookupGroups = inLookupGroups;
  }

  public String getSearchText()
  {
    return mSearchText;
  }

  public String[] getLookupGroups()
  {
    return mLookupGroups;
  }
}