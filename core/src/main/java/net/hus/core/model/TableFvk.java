package net.hus.core.model;

import java.io.Serializable;

public class TableFvk implements Serializable
{
  private static final long serialVersionUID = 908199922488294162L;

  private String mFvt;
  private String mFvk;

  private String mFgg;

  TableFvk()
  {
  }

  public TableFvk(String inTable, String inFvk, String inGroup)
  {
    mFvt = inTable;
    mFvk = inFvk;
    mFgg = inGroup;
  }

  public String getFvt()
  {
    return mFvt;
  }

  public void setFvt(String inTable)
  {
    mFvt = inTable;
  }

  public String getFvk()
  {
    return mFvk;
  }

  public void setFvk(String inFvk)
  {
    mFvk = inFvk;
  }

  public String getFgg()
  {
    return mFgg;
  }

  public void setFgg(String inGroup)
  {
    mFgg = inGroup;
  }
}