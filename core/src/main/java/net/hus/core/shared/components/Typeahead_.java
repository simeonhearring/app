package net.hus.core.shared.components;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.shared.model.Components.Type;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.LookupOptions;
import net.hus.core.shared.model.TypeaheadOption;

public class Typeahead_ extends ValueBoxBase_ implements LookupOptions
{
  private static final long serialVersionUID = 2913512356177277461L;

  private String mValue;
  private Field.Lookup mLookup;
  private List<TypeaheadOption> mOptions;

  @Override
  public Type cType()
  {
    return Type.TYPEAHEAD;
  }

  public String getValue()
  {
    return mValue;
  }

  public void setValue(String inValue)
  {
    mValue = inValue;
  }

  public List<TypeaheadOption> getOptions()
  {
    return mOptions;
  }

  @Override
  public void init()
  {
    if (mOptions == null)
    {
      mOptions = new ArrayList<>();
    }
  }

  @Override
  public void add(Lookup inLookup)
  {
    mOptions.add(inLookup);
  }

  @Override
  public Location getLocation()
  {
    return mLookup.getLocation();
  }

  @Override
  public String[] getLookupGroups()
  {
    return mLookup.getParameters().split(",");
  }

  public void setLookup(Field.Lookup inLookup)
  {
    mLookup = inLookup;
  }
}