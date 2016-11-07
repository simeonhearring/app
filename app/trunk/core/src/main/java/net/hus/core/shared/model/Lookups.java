package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.List;

public class Lookups implements Serializable
{
  private static final long serialVersionUID = 2580002478293381780L;

  private List<Lookup> mLookups;

  public void setLookups(List<Lookup> inLookups)
  {
    mLookups = inLookups;
  }

  public List<Lookup> getOptions()
  {
    return mLookups;
  }
}