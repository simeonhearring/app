package net.hus.core.shared.model;

import static net.hus.core.shared.model.Lookup.Size.SM;
import static net.hus.core.shared.model.Lookup.Size.XL;

import java.util.Comparator;

import net.hus.core.shared.util.EnumUtil;

public class Lookup extends AbstractModel implements TypeaheadOption
{
  private static final long serialVersionUID = 6439569552175264944L;

  private String mGroup;
  private String mCode;
  private String mName;
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

  public String getCode()
  {
    return mCode;
  }

  public void setCode(String inCode)
  {
    mCode = inCode;
  }

  public String getAbbreviation()
  {
    return mAbbreviation;
  }

  public void setAbbreviation(String inAbbreviation)
  {
    mAbbreviation = inAbbreviation;
  }

  public String getName()
  {
    return mName;
  }

  public void setName(String inDisplay)
  {
    mName = inDisplay;
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
    return mName;
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
    UNKNOWN(SM),
    YESNO(SM),
    GENDER(SM),
    TABLE(SM),
    // FGG(SM), // TODO should be TABLE
    FIELD(SM),
    LOOKUP(SM),
    COMPONENT(SM),
    COMMAND(SM),
    LAYOUT(SM),
    SECTION(SM), // not used?
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

    public static boolean isApp(String inGroup)
    {
      Group group = EnumUtil.valueOf(inGroup, values());
      return group != null;
    }

    public static boolean isXL(Group inGroup)
    {
      return inGroup != null && Size.XL.equals(inGroup.mSize);
    }
  }

  public static Comparator<Lookup> sortDisplay()
  {
    return new Comparator<Lookup>()
    {
      @Override
      public int compare(Lookup inO1, Lookup inO2)
      {
        return inO1.mName.compareToIgnoreCase(inO2.mName);
      }
    };
  }
}