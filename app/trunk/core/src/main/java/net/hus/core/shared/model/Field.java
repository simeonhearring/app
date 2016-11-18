package net.hus.core.shared.model;

import java.io.Serializable;

import org.gwtbootstrap3.client.ui.constants.HeadingSize;

import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.shared.util.EnumUtil;
import net.hus.core.shared.util.StringUtil;

public class Field extends AbstractModel
{
  private static final long serialVersionUID = -961088994106006040L;

  private String mName;
  private Type mType;
  private Properties mProperties;

  public Field()
  {
  }

  /* DB QUICK SAVE */
  public Field(Long inFieldId)
  {
    setId(inFieldId);
  }

  /* UI QUICK CREATE */
  public Field(String inName, Field.Type inType)
  {
    setNameType(inName, inType);
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
    if (mProperties == null)
    {
      mProperties = new Properties();
    }
    return mProperties;
  }

  public void setProperties(Properties inProperties)
  {
    mProperties = inProperties;
  }

  public Array getArray()
  {
    return mProperties.mArray;
  }

  public String getDateFormat()
  {
    return mProperties.mDateTime != null ? mProperties.mDateTime.mFormat : null;
  }

  public enum Component
  {
    FL00_,
    FV00_,
    BTN00_,
  }

  public enum Type implements EnumDisplay
  {
    STRING,
    NUMBER,
    DATE,
    TIME,
    TIMESTAMP,
    ARRAY,
    LOOKUP,
    TABLE; // do we need?

    public static boolean isArray(Type inType)
    {
      return Type.ARRAY.equals(inType) || Type.TABLE.equals(inType);
    }

    @Override
    public String display()
    {
      return StringUtil.toTitle(name());
    }
  }

  public static class Properties implements Serializable
  {
    private static final long serialVersionUID = 4839256266085591075L;

    private Type mType;
    private Display mDisplay;
    private Lookup mLookup;
    private Array mArray;
    private DateTime mDateTime;
    private Database mDatabase;

    public String getInfo()
    {
      StringBuilder sb = new StringBuilder();
      sb.append(" Display: [").append(mDisplay.mLong).append(" ");
      sb.append(mDisplay.mShort).append("]<br/>");
      if (mLookup != null)
      {
        sb.append(" Lookup: [").append(mLookup.getLocation()).append(" ");
        sb.append(mLookup.getParameters()).append("]");
      }
      return sb.toString();
    }

    public Type getType()
    {
      return mType;
    }

    public void setType(Type inType)
    {
      mType = inType;
    }

    public Display getDisplay()
    {
      if (mDisplay == null)
      {
        mDisplay = new Display();
      }
      return mDisplay;
    }

    public Lookup getLookup()
    {
      if (mLookup == null)
      {
        mLookup = new Lookup();
      }
      return mLookup;
    }

    public Array getArray()
    {
      if (mArray == null)
      {
        mArray = new Array();
      }
      return mArray;
    }

    public Database getDatabase()
    {
      if (mDatabase == null)
      {
        mDatabase = new Database();
      }
      return mDatabase;
    }

    public DateTime getDateTime()
    {
      if (mDateTime == null)
      {
        mDateTime = new DateTime();
      }
      return mDateTime;
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

  public static class DateTime implements Serializable
  {
    private static final long serialVersionUID = -267396618604514196L;

    private String mFormat;

    public String getFormat()
    {
      return mFormat;
    }

    public void setFormat(String inFormat)
    {
      mFormat = inFormat;
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

    public enum Location implements EnumDisplay
    {
      TABLE,
      RPC;

      @Override
      public String display()
      {
        return StringUtil.toTitle(name());
      }
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
    USERNAME(14L, Type.STRING),
    PASSWORD(15L, Type.STRING),
    FIELD(17L, Type.LOOKUP),
    FIELD_GROUP(18L, Type.LOOKUP),
    PROFILE(16L, Type.LOOKUP),

    FIRST_NAME(1L, Type.STRING),
    LAST_NAME(2L, Type.STRING),
    MIDDLE_NAME(3L, Type.STRING),
    ADDRESS(13L, Type.ARRAY),
    GENDER(12L, Type.LOOKUP),
    ;

    private Long mFid;
    private Type mType;

    private Fid(Long inFid, Type inType)
    {
      mFid = inFid;
      mType = inType;
    }

    public Long fid()
    {
      return mFid;
    }

    public Type type()
    {
      return mType;
    }
  }

  public boolean isDate()
  {
    return Field.Type.DATE.equals(mType);
  }

  public boolean isLookup()
  {
    return Field.Type.LOOKUP.equals(mType);
  }

  public boolean isArray()
  {
    return Type.isArray(getType());
  }

  public boolean isOneValue()
  {
    return mProperties.getDatabase().isOneValue();
  }

  public String getInfo()
  {
    StringBuilder ret = new StringBuilder();
    ret.append(" Name: ").append(getName());
    ret.append(" ID: ").append(getId());
    ret.append(" Type: ").append(getType());
    ret.append(mProperties.getInfo());
    return ret.toString();
  }

  public void update(DataType inType, String inValue)
  {
    switch (inType)
    {
      case DISPLAY_LONG:
        mProperties.mDisplay.setLong(inValue);
        break;
      case DISPLAY_SHORT:
        mProperties.mDisplay.setShort(inValue);
        break;
      case DATE_STORAGE_FORMAT:
        mProperties.getDateTime().setFormat(inValue);
        break;
      case LOOKUP_PARAMETERS:
        mProperties.getLookup().setParameters(inValue);
        break;
      case LOOKUP_LOCATION:
        mProperties.getLookup().setLocation(EnumUtil.valueOf(inValue, Lookup.Location.values()));
        break;
      default:
        break;
    }
  }

  public enum DataType implements EnumDisplay
  {
    DISPLAY_LONG,
    DISPLAY_SHORT,
    DATE_STORAGE_FORMAT,
    LOOKUP_PARAMETERS,
    LOOKUP_LOCATION;

    @Override
    public String display()
    {
      return StringUtil.toTitle(name().replaceAll("_", " "));
    }
  }

  public String getDisplayLong()
  {
    String ret = null;
    if (mProperties != null && mProperties.mDisplay != null)
    {
      ret = mProperties.mDisplay.mLong;
    }
    return ret;
  }

  public String getDisplayShort()
  {
    String ret = null;
    if (mProperties != null && mProperties.mDisplay != null)
    {
      ret = mProperties.mDisplay.mShort;
    }
    return ret;
  }

  private void setNameType(String inName, Field.Type inType)
  {
    mName = officialName(inName);
    mType = inType;
    getProperties().mType = inType;
    getProperties().getDisplay().mLong = inName;
  }

  public static String officialName(String inName)
  {
    return inName.toUpperCase().replaceAll(" ", "_");
  }

  public void setArray(Array inArray)
  {
    mProperties.mArray = inArray;
  }

  public void setLookup(Lookup inLookup)
  {
    mProperties.mLookup = inLookup;
  }

  public String getLookupParameters()
  {
    String ret = null;
    if (mProperties != null && mProperties.mLookup != null)
    {
      ret = mProperties.mLookup.mParameters;
    }
    return ret;
  }

  public Location getLookupLocation()
  {
    Location ret = null;
    if (mProperties != null && mProperties.mLookup != null)
    {
      ret = mProperties.mLookup.mLocation;
    }
    return ret;
  }
}