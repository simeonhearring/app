package net.hus.core.model;

import java.io.Serializable;

public class Field extends AbstractModel
{
  private static final long serialVersionUID = -961088994106006040L;

  private String mName;
  private Type mType;
  private Properties mProperties;
  @Deprecated
  private Integer mSort;

  private String mDisplay;

  public Field()
  {
  }

  /* DB QUICK SAVE */
  public Field(Long inFieldId)
  {
    setId(inFieldId);
  }

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

  public enum Component
  {
    FL00_,
    FV00_
  }

  public enum Type
  {
    STRING,
    NUMBER,
    DATE,
    TIME,
    TIMESTAMP,
    ARRAY,
    LOOKUP,
    TABLE;

    public static boolean isArray(Type inType)
    {
      return Type.ARRAY.equals(inType) || Type.TABLE.equals(inType);
    }
  }

  public static class Properties implements Serializable
  {
    private static final long serialVersionUID = 4839256266085591075L;

    private Type mType;
    private Display mDisplay;
    private Lookup mLookup;
    private Array mArray;

    public Display getDisplay()
    {
      return mDisplay;
    }

    public void setDisplay(Display inDisplay)
    {
      mDisplay = inDisplay;
    }

    public Lookup getLookupGroup()
    {
      return mLookup;
    }

    public void setLookupGroup(Lookup inLookup)
    {
      mLookup = inLookup;
    }

    public Array getArray()
    {
      return mArray;
    }

    public void setArray(Array inArray)
    {
      mArray = inArray;
    }

    public Type getType()
    {
      return mType;
    }

    public void setType(Type inType)
    {
      mType = inType;
    }
  }

  public static class Array implements Serializable
  {
    private static final long serialVersionUID = 7715620771565891829L;

    private Integer mSize;
    private String[] mLabels;

    public Array()
    {
    }

    public Array(Integer inSize, String... inLabels)
    {
      mSize = inSize;
      mLabels = inLabels;
    }

    public Integer getSize()
    {
      return mSize;
    }

    public void setSize(Integer inSize)
    {
      mSize = inSize;
    }

    public String[] getLabels()
    {
      return mLabels;
    }

    public void setLabels(String[] inLabel)
    {
      mLabels = inLabel;
    }
  }

  public static class Lookup implements Serializable
  {
    private static final long serialVersionUID = -5683793682523488618L;

    private Location mLocation;
    private String mParameters;

    public Lookup()
    {
    }

    public Lookup(Location inLocation, String inParameters)
    {
      mLocation = inLocation;
      mParameters = inParameters;
    }

    public enum Location
    {
      TABLE,
      RPC
    }

    public Location getLocation()
    {
      return mLocation;
    }

    public void setLocation(Location inLocation)
    {
      mLocation = inLocation;
    }

    public String getParameters()
    {
      return mParameters;
    }

    public void setParameters(String inParameters)
    {
      mParameters = inParameters;
    }
  }

  public static class Display implements Serializable
  {
    private static final long serialVersionUID = 2627664336015710030L;

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

  public boolean isArray()
  {
    return Type.isArray(getType());
  }
}