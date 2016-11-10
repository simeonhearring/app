package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Table implements Serializable
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