package net.hus.core.shared.model;

import java.io.Serializable;

import org.gwtbootstrap3.client.ui.constants.HeadingSize;

public class Field extends AbstractModel
{
  private static final long serialVersionUID = -961088994106006040L;

  private String mName;
  private Type mType;
  private Properties mProperties;

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

  public String getDisplay()
  {
    return mDisplay;
  }

  public void setDisplay(String inDisplay)
  {
    mDisplay = inDisplay;
  }

  public Array.Properties getArrayProperties()
  {
    return mProperties.mArray.mProperties;
  }

  public enum Component
  {
    FL00_,
    FV00_,
    BTN00_,
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
    private Database mDatabase;

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

    public Database getDatabase()
    {
      return mDatabase;
    }

    public void setDatabase(Database inDatabase)
    {
      mDatabase = inDatabase;
    }
  }

  public static class Database implements Serializable
  {
    private static final long serialVersionUID = -5221208251501108527L;

    private Boolean mOneValue;

    public Boolean getOneValue()
    {
      return mOneValue;
    }

    public void setOneValue(Boolean inOneValue)
    {
      mOneValue = inOneValue;
    }

    public boolean isOneValue()
    {
      return mOneValue != null && mOneValue;
    }
  }

  public static class Array implements Serializable
  {
    private static final long serialVersionUID = 7715620771565891829L;

    private Integer mSize;
    private String[] mLabels;
    private Properties mProperties;

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

    public Properties getProperties()
    {
      return mProperties;
    }

    public void setProperties(Properties inProperties)
    {
      mProperties = inProperties;
    }

    public static class Properties implements Serializable
    {
      private static final long serialVersionUID = 6023117565338477729L;

      private Integer mShowBottomAtRow;
      private Boolean mAltRow;
      private String mAltEvenColor;
      private String mAltOddColor;
      private HeadingSize mHeadingSize;

      Properties()
      {
      }

      public Properties(Integer inShowBottomAtRow, Boolean inAltRow, String inAltEvenColor,
          String inAltOddColor, HeadingSize inHeadingSize)
      {
        mShowBottomAtRow = inShowBottomAtRow;
        mAltRow = inAltRow;
        mAltEvenColor = inAltEvenColor;
        mAltOddColor = inAltOddColor;
        mHeadingSize = inHeadingSize;
      }

      public Integer getShowBottomAtRow()
      {
        return mShowBottomAtRow;
      }

      public void setShowBottomAtRow(Integer inShowBottomAtRow)
      {
        mShowBottomAtRow = inShowBottomAtRow;
      }

      public Boolean getAltRow()
      {
        return mAltRow;
      }

      public void setAltRow(Boolean inAltRow)
      {
        mAltRow = inAltRow;
      }

      public String getAltEvenColor()
      {
        return mAltEvenColor;
      }

      public void setAltEvenColor(String inAltEvenColor)
      {
        mAltEvenColor = inAltEvenColor;
      }

      public String getAltOddColor()
      {
        return mAltOddColor;
      }

      public void setAltOddColor(String inAltOddColor)
      {
        mAltOddColor = inAltOddColor;
      }

      public HeadingSize getHeadingSize()
      {
        return mHeadingSize;
      }

      public void setHeadingSize(HeadingSize inHeadingSize)
      {
        mHeadingSize = inHeadingSize;
      }
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

  public enum Fid
  {
    FIRST_NAME(1L),
    LAST_NAME(2L),
    MIDDLE_NAME(3L),
    USERNAME(14L),
    PASSWORD(15L);

    private Long mFid;

    private Fid(Long inFid)
    {
      mFid = inFid;
    }

    public Long fid()
    {
      return mFid;
    }
  }

  public boolean isArray()
  {
    return Type.isArray(getType());
  }

  public boolean isOneValue()
  {
    return mProperties.getDatabase().isOneValue();
  }
}