package net.hus.core.client.ui.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.hus.core.shared.model.TypeaheadOption;

public class TypeaheadData
{
  private Map<String, TypeaheadOption> mData = new HashMap<>();

  public TypeaheadOption get(String inValue)
  {
    return mData.get(inValue);
  }

  public <T extends TypeaheadOption> void setOptions(List<T> inOptions)
  {
    mData = new HashMap<>();
    for (T value : inOptions)
    {
      mData.put(value.fvk(), value);
    }
  }

  public <T extends TypeaheadOption> void put(List<T> inOptions)
  {
    mData = new HashMap<>();
    for (TypeaheadOption value : inOptions)
    {
      mData.put(value.fvk(), value);
    }
  }
}