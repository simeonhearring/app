package net.hus.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Template implements Serializable
{
  private static final long serialVersionUID = -1612041487406778530L;

  public enum Name
  {
    BLOG,
    WEB,
    MARKET;
  }


  private String mName;

  private List<Section> mSections = new ArrayList<>();

  public String getName()
  {
    return mName;
  }

  public void setName(String inName)
  {
    mName = inName;
  }

  public List<Section> getSections()
  {
    return mSections;
  }

  public static class Section implements Serializable
  {
    private static final long serialVersionUID = 6166844602372421962L;

    public enum Name
    {
      BLOGL01,
      BLOGC01,
      WEBL01,
      WEBC01,
      WEBR01
    }
  }
}