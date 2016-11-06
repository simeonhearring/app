package net.hus.core.shared.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.constants.HeadingSize;

import net.hus.core.shared.model.Field.Type;

public class FlexTable_ extends UIObject_
{
  private static final long serialVersionUID = -4918962966365747922L;

  private int mCols, mMaxRows;
  private HeadingSize mHeadingSize;
  private String[] mHeaders;
  private Type[] mTypes;
  private Table mTable;

  public FlexTable_()
  {
  }

  public FlexTable_(int inCols, int inMaxRow)
  {
    mCols = inCols;
    mMaxRows = inMaxRow;
    mTable = new Table();
  }

  public void setHeaders(String[] inHeaders)
  {
    mHeaders = inHeaders;
  }

  public String[] getHeaders()
  {
    return mHeaders;
  }

  public void setTable(Table inTable)
  {
    mTable = inTable;
  }

  public void setValue(String... inObject)
  {
    mTable.add(inObject);
  }

  public Table getTable()
  {
    return mTable;
  }

  public int getCols()
  {
    return mCols;
  }

  public int getMaxRows()
  {
    return mMaxRows;
  }

  public Type[] getDataTypes()
  {
    return mTypes;
  }

  public void setTypes(Type... inTypes)
  {
    mTypes = inTypes;
  }

  public HeadingSize getHeadSize()
  {
    return mHeadingSize;
  }

  public void setHeadingSize(HeadingSize inHeadSize)
  {
    mHeadingSize = inHeadSize;
  }

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
}