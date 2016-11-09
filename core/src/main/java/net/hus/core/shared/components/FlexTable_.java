package net.hus.core.shared.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.hus.core.shared.model.Field.Array;

public class FlexTable_ extends UIObject_
{
  private static final long serialVersionUID = -4918962966365747922L;

  private Array mArray;

  public static class Table implements Serializable
  {
    private static final long serialVersionUID = 5268241766893875318L;

    private List<String[]> mTable = new ArrayList<>();

    public List<String[]> getTable()
    {
      return mTable;
    }

    public void add(String[] inObject)
    {
      mTable.add(inObject);
    }

    public void setTable(List<String[]> inTable)
    {
      mTable = inTable;
    }
  }

  public Array getArray()
  {
    return mArray;
  }

  public void setArray(Array inArray)
  {
    mArray = inArray;
  }
}