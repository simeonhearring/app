package net.hus.core.shared.common;

import java.util.HashMap;
import java.util.Map;

public class EnumLookup
{
  private final Map<Enum<?>, Item> mMap = new HashMap<>();

  public EnumLookup(Enum<?>[] inValues, String inDetail)
  {
    for (Enum<?> aenum : inValues)
    {
      String code = "";
      String name = "";
      String[] array = inDetail.split(",");

      for (String value : array)
      {
        String[] subarray = value.split("\\|");
        if (aenum.name().equals(subarray[0]))
        {
          code = subarray.length >= 2 ? subarray[1] : "";
          name = subarray.length >= 3 ? subarray[2] : "";
          break;
        }
      }

      mMap.put(aenum, new Item(code, name));
    }
  }

  public String getName(Enum<?> inKey)
  {
    return mMap.get(inKey).getName();
  }

  public String getCode(Enum<?> inKey)
  {
    return mMap.get(inKey).getCode();
  }

  private static class Item
  {
    private final String mCode;
    private final String mName;

    public Item(String inCode, String inName)
    {
      mName = inName;
      mCode = inCode;
    }

    public String getCode()
    {
      return mCode;
    }

    public String getName()
    {
      return mName;
    }
  }
}