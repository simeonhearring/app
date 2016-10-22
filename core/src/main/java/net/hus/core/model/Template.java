package net.hus.core.model;

public class Template
{
  public enum Name
  {
    BLOG,
    WEB,
    MARKET;
  }

  private String mName;

  public String getName()
  {
    return mName;
  }

  public void setName(String inName)
  {
    mName = inName;
  }
}