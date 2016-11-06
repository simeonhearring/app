package net.hus.core.shared.model;

import static net.hus.core.shared.model.Lookup.Size.SM;
import static net.hus.core.shared.model.Lookup.Size.XL;

public class Lookup extends AbstractModel
{
  private static final long serialVersionUID = 6439569552175264944L;

  public enum Size
  {
    SM,
    XL
  }

  public enum Group
  {
    BLANK(SM),
    TABLE(SM),
    FIELD_GROUP(SM),
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
  }

  private String mGroup;
  private String mName;
  private String mAbbreviation;
  private String mDescription;
  private Integer mSort;
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
}