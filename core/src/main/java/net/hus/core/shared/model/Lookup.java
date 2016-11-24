package net.hus.core.shared.model;

import static net.hus.core.shared.model.Lookup.Size.SM;
import static net.hus.core.shared.model.Lookup.Size.XL;

import net.hus.core.shared.util.EnumUtil;

public class Lookup extends AbstractModel implements TypeaheadOption
{
  private static final long serialVersionUID = 6439569552175264944L;

  private String mGroup;
  private String mName;
  private String mDisplay;
  private String mAbbreviation;
  private String mDescription;
  private Integer mSort;
  private Long mAltId;
  private String mXL;

  public String getGroup()
  {
    return mGroup;
  }

  public void setGroup(String inGroup)
  {
    mGroup = inGroup;
  }

  public void setGroup(Group inGroup)
  {
    mGroup = inGroup.name();
  }

  public Group group()
  {
    return EnumUtil.valueOf(mGroup, Group.values());
  }

  public String getName()
  {
    return mName;
  }

  public void setName(String inName)
  {
    mName = inName;
  }

  public String getAbbreviation()
  {
    return mAbbreviation;
  }

  public void setAbbreviation(String inAbbreviation)
  {
    mAbbreviation = inAbbreviation;
  }

  public String getDisplay()
  {
    return mDisplay;
  }

  public void setDisplay(String inDisplay)
  {
    mDisplay = inDisplay;
  }

  public Integer getSort()
  {
    return mSort;
  }

  public void setSort(Integer inSort)
  {
    mSort = inSort;
  }

  public String getDescription()
  {
    return mDescription;
  }

  public void setDescription(String inDescription)
  {
    mDescription = inDescription;
  }

  public String getXL()
  {
    return mXL;
  }

  public void setXL(String inXL)
  {
    mXL = inXL;
  }

  public Long getAltId()
  {
    return mAltId;
  }

  public void setAltId(Long inAltId)
  {
    mAltId = inAltId;
  }

  @Override
  public String option()
  {
    return mDisplay;
  }

  @Override
  public Long optionId()
  {
    Long altId = getAltId();
    return altId != null ? altId : getId();
  }

  public enum Size
  {
    SM,
    XL
  }

  public enum Group
  {
    BLANK(SM),
    FVT(SM),
    FIELD(SM),
    LOOKUP(SM),
    FIELD_GROUP(SM),
    COMPONENT(SM),
    UNKNOWN(SM),
    DAYSOFWEEK(SM),
    MONTHSOFYEAR(SM),
    YESNO(SM),
    GENDER(SM),
    APP_PROFILE(XL),
    PROFILE(XL),
    COMPONENTS(XL);

    private Size mSize;

    private Group(Size inSize)
    {
      mSize = inSize;
    }

    public Size getSize()
    {
      return mSize;
    }

    public static boolean isXL(Group inGroup)
    {
      return inGroup != null && Size.XL.equals(inGroup.mSize);
    }
  }
}