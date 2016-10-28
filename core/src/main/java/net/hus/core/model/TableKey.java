package net.hus.core.model;

import java.io.Serializable;

public class TableKey implements Serializable
{
  private static final long serialVersionUID = 908199922488294162L;

  private String mTable;
  private String mKey;

  TableKey()
  {
  }

  public TableKey(String inTable, String inKey)
  {
    mTable = inTable;
    mKey = inKey;
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
}