package net.hus.core.model;

import java.io.Serializable;

public class TableFvk implements Serializable
{
  private static final long serialVersionUID = 908199922488294162L;

  private String mTable;
  private String mFvk;

  private String mGroup;

  TableFvk()
  {
  }

  public TableFvk(String inTable, String inFvk, String inGroup)
  {
    mTable = inTable;
    mFvk = inFvk;
    mGroup = inGroup;
  }

  public String getTable()
  {
    return mTable;
  }

  public void setTable(String inTable)
  {
    mTable = inTable;
  }

  public String getFvk()
  {
    return mFvk;
  }

  public void setFvk(String inFvk)
  {
    mFvk = inFvk;
  }

  public String getGroup()
  {
    return mGroup;
  }

  public void setGroup(String inGroup)
  {
    mGroup = inGroup;
  }
}