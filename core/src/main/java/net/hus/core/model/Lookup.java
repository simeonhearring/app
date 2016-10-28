package net.hus.core.model;

public class Lookup extends AbstractModel
{
  private static final long serialVersionUID = 6439569552175264944L;

  public enum Group
  {
    TABLE,
    FIELD_GROUP,
    UNKNOWN,
    DAYSOFWEEK,
    MONTHSOFYEAR,
    YESNO,
    GENDER,
  }

  private String mGroup;
  private String mName;
  private String mAbbreviation;
  private String mDescription;
  private Integer mSort;

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
}