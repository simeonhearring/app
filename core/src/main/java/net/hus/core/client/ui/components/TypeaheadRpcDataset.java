package net.hus.core.client.ui.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gwtbootstrap3.extras.typeahead.client.base.Dataset;
import org.gwtbootstrap3.extras.typeahead.client.base.Suggestion;
import org.gwtbootstrap3.extras.typeahead.client.base.SuggestionCallback;

import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.common.RpcCallback;
import net.hus.core.shared.command.LookupCommand;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.TypeaheadOption;

public class TypeaheadRpcDataset extends Dataset<TypeaheadOption>
{
  private TypeaheadData mOptions;
  private String[] mLookupGroups;

  public TypeaheadRpcDataset(TypeaheadData inOptions, String... inLookupGroups)
  {
    mOptions = inOptions;
    mLookupGroups = inLookupGroups;
  }

  @Override
  public void findMatches(String inQuery, SuggestionCallback<TypeaheadOption> inCallback)
  {
    query(inQuery, inCallback);
  }

  private void query(final String inQuery, final SuggestionCallback<TypeaheadOption> inCallback)
  {
    Global.fire(new LookupCommand(inQuery, mLookupGroups), new RpcCallback<LookupCommand>()
    {
      @Override
      public void onRpcSuccess(LookupCommand inCommand)
      {
        List<Lookup> options = inCommand.getData().getOptions();
        mOptions.put(options);
        inCallback.execute(options(inQuery.toLowerCase(), options));
      }
    });
  }

  private Collection<Suggestion<TypeaheadOption>> options(String inQuery, List<Lookup> inOptions)
  {
    List<Suggestion<TypeaheadOption>> ret = new ArrayList<>();
    for (TypeaheadOption value : inOptions)
    {
      if (value.option().toLowerCase().contains(inQuery))
      {
        ret.add(Suggestion.create(value.option(), value, this));
      }
    }
    return ret;
  }
}