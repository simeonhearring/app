package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lookups implements Serializable
{
  private static final long serialVersionUID = 2580002478293381780L;

  private Map<String, List<Lookup>> mLookups = new HashMap<>();

  public void add(String inKey, List<Lookup> inList)
  {
    mLookups.put(inKey, inList);
  }
}