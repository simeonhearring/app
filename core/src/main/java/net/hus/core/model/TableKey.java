package net.hus.core.model;

import java.io.Serializable;

public class TableKey implements Serializable
{
  private static final long serialVersionUID = 908199922488294162L;

  private String mTable;
  private String mKey;

  private String mGroup;

  TableKey()
  {
  }

  public TableKey(String inTable, String inKey, String inGroup)
  {
    mTable = inTable;
    mKey = inKey;
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

  public String getKey()
  {
    return mKey;
  }

  public void setKey(String inKey)
  {
    mKey = inKey;
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