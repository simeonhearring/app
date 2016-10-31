package net.hus.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable
{
  private static final long serialVersionUID = -1612041487406778530L;

  public enum Name
  {
    BLOG,
    WEB,
    MARKET,
    LOGIN;
  }


  private Name mName;
  private String mComponentsName;

  private List<Section> mSections = new ArrayList<>();

  public Name getName()
  {
    return mName;
  }

  public void setName(Name inName)
  {
    mName = inName;
  }

  public List<Section> getSections()
  {
    return mSections;
  }

  public String getComponentsName()
  {
    return mComponentsName;
  }

  public void setComponentsName(String inComponentsName)
  {
    mComponentsName = inComponentsName;
  }

  public static class Section implements Serializable
  {
    private static final long serialVersionUID = 6166844602372421962L;

    public enum Name
    {
      MARR1L01,
      MARR1C01,
      MARR201,
      MARR202,
      MARR203,
      MARR204,
      MARR301,
      MARR302,
      MARR303,
      MARR304,
      MARR305,
      MARR306,
      BLOGL01,
      BLOGC01,
      WEBL01,
      WEBC01,
      WEBR01,
      LOGINL01,
      LOGINC01,
      LOGINR01,
    }
  }
}