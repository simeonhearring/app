package net.hus.core.model;

public class Field extends Model
{
  public enum Type
  {
    STRING,
    NUMBER,
    DATE,
    TIME,
    TIMESTAMP,
    ARRAY,
    LOOKUP
  }

  public static class Properties
  {
    private Display mDisplay;

    public Display getDisplay()
    {
      return mDisplay;
    }

    public void setDisplay(Display inDisplay)
    {
      mDisplay = inDisplay;
    }
  }

  public static class Display
  {
    private String mLong;
    private String mShort;

    public String getLong()
    {
      return mLong;
    }

    public void setLong(String inLong)
    {
      mLong = inLong;
    }

    public void setShort(String inShort)
    {
      mShort = inShort;
    }

    public String getShort()
    {
      return mShort;
    }
  }

  private String mName;
  private Type mType;
  private Properties mProperties;
  private Integer mSort;

  private String mDisplay;

  public String getName()
  {
    return mName;
  }

  public void setName(String inName)
  {
    mName = inName;
  }

  public Type getType()
  {
    return mType;
  }

  public void setType(Type inType)
  {
    mType = inType;
  }

  public Properties getProperties()
  {
    return mProperties;
  }

  public void setProperties(Properties inProperties)
  {
    mProperties = inProperties;
  }

  public Integer getSort()
  {
    return mSort;
  }

  public void setSort(Integer inSort)
  {
    mSort = inSort;
  }

  public String getDisplay()
  {
    return mDisplay;
  }

  public void setDisplay(String inDisplay)
  {
    mDisplay = inDisplay;
  }
}