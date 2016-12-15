package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lookups extends AbstractModel implements Serializable
{
  private static final long serialVersionUID = 2580002478293381780L;

  private String mCode; // ? mGroup
  private String mName;
  private List<Lookup> mLookups;

  public void setLookups(List<Lookup> inLookups)
  {
    mLookups = inLookups;
  }

  public List<Lookup> getOptions()
  {
    return mLookups;
  }

  public String getCode()
  {
    return mCode;
  }

  public void setCode(String inName)
  {
    mCode = inName;
  }

  public String getName()
  {
    return mName;
  }

  public void setName(String inName)
  {
    mName = inName;
  }

  public Map<Type, List<Lookup>> getGroup()
  {
    Map<Type, List<Lookup>> ret = new HashMap<>();

    for (Lookup value : mLookups)
    {
      Type sys = Lookup.Group.isApp(value.getCode()) ? Type.Application : Type.Custom;
      if (!ret.containsKey(sys))
      {
        ret.put(sys, new ArrayList<Lookup>());
      }
      ret.get(sys).add(value);
    }

    Comparator<Lookup> sort = Lookup.sortDisplay();
    Collections.sort(ret.get(Type.Application), sort);
    Collections.sort(ret.get(Type.Custom), sort);

    return ret;
  }

  public enum Type
  {
    Application,
    Custom
  }
}