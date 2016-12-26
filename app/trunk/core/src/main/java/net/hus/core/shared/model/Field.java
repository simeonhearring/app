package net.hus.core.shared.model;

import static net.hus.core.shared.util.NumberUtil.toInt;
import static net.hus.core.shared.util.NumberUtil.toInteger;
import static net.hus.core.shared.util.NumberUtil.toLong;
import static net.hus.core.shared.util.StringUtil.toTitle;
import static net.hus.core.shared.util.StringUtil.toValue;

import java.io.Serializable;

import org.gwtbootstrap3.client.ui.constants.HeadingSize;

import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.shared.util.EnumUtil;

public class Field extends AbstractModel
{
  private static final long serialVersionUID = -961088994106006040L;

  private String mCode;
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
    setCodeType(inName, inType);
  }

  public String getCode()
  {
    return mCode;
  }

  public void setCode(String inCode)
  {
    mCode = inCode;
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
    TABLE;

    public static boolean isArray(Type inType)
    {
      return Type.ARRAY.equals(inType);
    }

    public static boolean isTable(Type inType)
    {
      return Type.TABLE.equals(inType);
    }

    @Override
    public String display()
    {
      return toTitle(name());
    }
  }

  public static class Properties implements Serializable
  {
    private static final long serialVersionUID = 4839256266085591075L;

    private Field.Type mType;
    private Components.Type mCType;
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

    public Components.Type getCType()
    {
      return mCType;
    }

    public void setCType(Components.Type inCType)
    {
      mCType = inCType;
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
    private Long[] mFields; // TABLE only
    private Components.Type[] mCTypes; // TABLE only
    private String mFvt, mFgg; // TABLE only
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

    public Long[] getFields()
    {
      return mFields;
    }

    public void setFields(Long... inFields)
    {
      mFields = inFields;
    }

    public void setFields(String[] inFields)
    {
      Long[] ret = null;
      if (inFields != null && inFields.length != 0)
      {
        ret = new Long[inFields.length];
        for (int i = 0; i < ret.length; i++)
        {
          ret[i] = toLong(inFields[i]);
        }
      }
      mFields = ret;
    }

    public Components.Type[] getCTypes()
    {
      return mCTypes;
    }

    public void setCTypes(Components.Type... inCTypes)
    {
      mCTypes = inCTypes;
    }

    public String getFvt()
    {
      return mFvt;
    }

    public void setFvt(String inFvt)
    {
      mFvt = inFvt;
    }

    public String getFgg()
    {
      return mFgg;
    }

    public void setFgg(String inFgg)
    {
      mFgg = inFgg;
    }

    public static class Properties implements Serializable
    {
      private static final long serialVersionUID = 6023117565338477729L;

      private Integer mMaxHeight;
      private Integer mShowBottomAtRow;
      private Boolean mAltRow;
      private String mAltEvenColor;
      private String mAltOddColor;
      private HeadingSize mHeadingSize;

      Properties()
      {
      }

      public Properties(Integer inMaxHeight, Integer inShowBottomAtRow, Boolean inAltRow,
          String inAltEvenColor, String inAltOddColor, HeadingSize inHeadingSize)
      {
        mMaxHeight = inMaxHeight;
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

      public Integer getMaxHeight()
      {
        return mMaxHeight;
      }

      public void setMaxHeight(Integer inMaxHeight)
      {
        mMaxHeight = inMaxHeight;
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
        return toTitle(name());
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

  public enum Table
  {
    PERSON,
    JUNIT,
    APP,
    LOGIN
  }

  public enum Fid
  {
    USERNAME(-1L, Type.STRING),
    PASSWORD(-2L, Type.STRING),

    EMAIL(-3L, Type.STRING),
    FIRST_NAME(-4L, Type.STRING),
    LAST_NAME(-5L, Type.STRING),
    MIDDLE_NAME(-6L, Type.STRING),
    GENDER(-7L, Type.LOOKUP),

    PAGE(-8L, Type.LOOKUP),
    FIELD(-9L, Type.LOOKUP),
    FIELD_TABLE(-10L, Type.LOOKUP),
    PROFILE(-11L, Type.LOOKUP),
    BIRTH_DATE(-12L, Type.DATE),
    APP(-13L, Type.LOOKUP),

    // ADDRESS(13L, Type.ARRAY),
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

  public boolean isTable()
  {
    return Type.isTable(getType());
  }

  public boolean isOneValue()
  {
    return mProperties.getDatabase().isOneValue();
  }

  public String getInfo()
  {
    StringBuilder ret = new StringBuilder();
    ret.append(" Code: ").append(getCode());
    ret.append(" ID: ").append(getId());
    ret.append(" Type: ").append(getType());
    ret.append(mProperties.getInfo());
    return ret.toString();
  }

  public void update(DataType inType, String inValue)
  {
    update(inType, (Object) inValue);
  }

  public void update(DataType inType, Object inValue)
  {
    switch (inType)
    {
      case DISPLAY_LONG:
        mProperties.mDisplay.setLong((String) inValue);
        break;
      case DISPLAY_SHORT:
        mProperties.mDisplay.setShort((String) inValue);
        break;
      case DATE_STORAGE_FORMAT:
        mProperties.getDateTime().setFormat((String) inValue);
        break;
      case LOOKUP_PARAMETERS:
        mProperties.getLookup().setParameters((String) inValue);
        break;
      case LOOKUP_LOCATION:
        mProperties.getLookup()
        .setLocation(EnumUtil.valueOf((String) inValue, Lookup.Location.values()));
        break;
      case ARRAY_LABELS:
        mProperties.getArray().setLabels(((String) inValue).split(","));
        break;
      case ARRAY_FIELDS:
        mProperties.getArray().setFields(((String) inValue).split(","));
        break;
      case ARRAY_CTYPES:
        mProperties.getArray().setCTypes((Components.Type[]) inValue);
        break;
      case ARRAY_SIZE:
        mProperties.getArray().setSize(toInteger((String) inValue));
        break;
      case ARRAY_HEADING_SIZE:
        mProperties.getArray().getProperties()
        .setHeadingSize(EnumUtil.valueOf((String) inValue, HeadingSize.values()));
        break;
      case ARRAY_ALTERNATE_COLOR:
        mProperties.getArray().getProperties().setAltRow(Boolean.valueOf((String) inValue));
        break;
      case ARRAY_ALTERNATE_COLOR_EVEN:
        mProperties.getArray().getProperties().setAltEvenColor((String) inValue);
        break;
      case ARRAY_ALTERNATE_COLOR_ODD:
        mProperties.getArray().getProperties().setAltOddColor((String) inValue);
        break;
      case ARRAY_BOTTOM_ROW_AT:
        mProperties.getArray().getProperties()
        .setShowBottomAtRow(toInteger((String) inValue));
        break;
      case ARRAY_FVK:
        mProperties.getArray().setFvt((String) inValue);
        break;
      case ARRAY_FGG:
        mProperties.getArray().setFgg((String) inValue);
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
    LOOKUP_LOCATION,
    ARRAY_SIZE,
    ARRAY_LABELS,
    ARRAY_FIELDS,
    ARRAY_CTYPES,
    ARRAY_HEADING_SIZE,
    ARRAY_ALTERNATE_COLOR_ODD,
    ARRAY_ALTERNATE_COLOR_EVEN,
    ARRAY_ALTERNATE_COLOR,
    ARRAY_BOTTOM_ROW_AT,
    ARRAY_FVK,
    ARRAY_FGG;

    @Override
    public String display()
    {
      return toTitle(name().replaceAll("_", " "));
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

  private void setCodeType(String inCode, Field.Type inType)
  {
    mCode = officialName(inCode);
    mType = inType;
    getProperties().mType = inType;
    getProperties().getDisplay().mLong = inCode;
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

  public String lookupParameters()
  {
    String ret = null;
    if (mProperties != null && mProperties.mLookup != null)
    {
      ret = mProperties.mLookup.mParameters;
    }
    return ret;
  }

  public Location lookupLocation()
  {
    Location ret = null;
    if (mProperties != null && mProperties.mLookup != null)
    {
      ret = mProperties.mLookup.mLocation;
    }
    return ret;
  }

  public int arraySize()
  {
    int ret = 1;
    if (mProperties != null && mProperties.mArray != null)
    {
      ret = toInt(mProperties.mArray.mSize, 1);
    }
    return ret;
  }

  public String arrayLabel(int inPos)
  {
    String ret = null;
    if (mProperties != null && mProperties.mArray != null && mProperties.mArray.mLabels != null)
    {
      String[] labels = mProperties.mArray.mLabels;
      if (labels.length > inPos)
      {
        ret = labels[inPos];
      }
    }

    if (ret == null)
    {
      ret = "--enter label--";
    }
    return ret;
  }

  public Long fieldId(int inPos)
  {
    Long ret = null;
    if (mProperties != null && mProperties.mArray != null && mProperties.mArray.mFields != null)
    {
      Long[] fields = mProperties.mArray.mFields;
      if (fields.length > inPos)
      {
        ret = fields[inPos];
      }
    }
    return ret;
  }

  public Components.Type cType(int inPos)
  {
    Components.Type ret = null;
    if (mProperties != null && mProperties.mArray != null && mProperties.mArray.mCTypes != null)
    {
      Components.Type[] cType = mProperties.mArray.mCTypes;
      if (cType.length > inPos)
      {
        ret = cType[inPos];
      }
    }
    return ret;
  }

  public HeadingSize arrayHeadSize()
  {
    HeadingSize ret = null;
    if (mProperties != null && mProperties.mArray != null && mProperties.mArray.mProperties != null)
    {
      ret = mProperties.mArray.mProperties.mHeadingSize;
    }

    if (ret == null)
    {
      ret = HeadingSize.H4;
    }
    return ret;
  }

  public boolean isLookupParam(String inText)
  {
    return mProperties.mLookup.mParameters.indexOf(inText + ",") != -1;
  }

  public String getArrayAltEven()
  {
    String ret = null;
    if (mProperties != null && mProperties.mArray != null && mProperties.mArray.mProperties != null)
    {
      ret = mProperties.mArray.mProperties.mAltEvenColor;
    }
    return ret;
  }

  public String getArrayAltOdd()
  {
    String ret = null;
    if (mProperties != null && mProperties.mArray != null && mProperties.mArray.mProperties != null)
    {
      ret = mProperties.mArray.mProperties.mAltOddColor;
    }
    return ret;
  }

  public Boolean isArrayAlt()
  {
    Boolean ret = null;
    if (mProperties != null && mProperties.mArray != null && mProperties.mArray.mProperties != null)
    {
      ret = mProperties.mArray.mProperties.mAltRow;
    }
    return ret != null && ret;
  }

  public String getArrayBottomRow()
  {
    Integer ret = null;
    if (mProperties != null && mProperties.mArray != null && mProperties.mArray.mProperties != null)
    {
      ret = mProperties.mArray.mProperties.mShowBottomAtRow;
    }
    return toValue(ret);
  }

  public String getArrayFvt()
  {
    String ret = null;
    if (mProperties != null && mProperties.mArray != null)
    {
      ret = mProperties.mArray.mFvt;
    }
    return ret;
  }

  public String getArrayFgg()
  {
    String ret = null;
    if (mProperties != null && mProperties.mArray != null)
    {
      ret = mProperties.mArray.mFgg;
    }
    return ret;
  }

  public boolean isPartOfTable(Long inFid)
  {
    for (Long value : getArray().mFields)
    {
      if (inFid.equals(value))
      {
        return true;
      }
    }
    return false;
  }

}