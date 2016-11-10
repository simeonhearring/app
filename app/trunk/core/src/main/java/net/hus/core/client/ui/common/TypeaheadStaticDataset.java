package net.hus.core.client.ui.common;

import java.util.List;

import org.gwtbootstrap3.extras.typeahead.client.base.CollectionDataset;

import net.hus.core.shared.model.TypeaheadOption;

public class TypeaheadStaticDataset extends CollectionDataset<TypeaheadOption>
{
  public TypeaheadStaticDataset(TypeaheadData inOptions, List<TypeaheadOption> inList)
  {
    super(inList);
    inOptions.put(inList);
  }

  @Override
  public String getValue(TypeaheadOption inOption)
  {
    return inOption.option();
  }
}