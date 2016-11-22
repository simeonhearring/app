package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.List;

public class Lookups extends AbstractModel implements Serializable
{
  private static final long serialVersionUID = 2580002478293381780L;

  private String mName;
  private String mDisplay;
  private List<Lookup> mLookups;

  public void setLookups(List<Lookup> inLookups)
  {
    mLookups = inLookups;
  }

  public List<Lookup> getOptions()
  {
    return mLookups;
  }

  public String getName()
  {
    return mName;
  }

  public void setName(String inName)
  {
    mName = inName;
  }

  public String getDisplay()
  {
    return mDisplay;
  }

  public void setDisplay(String inDisplay)
  {
    mDisplay = inDisplay;
  }
}