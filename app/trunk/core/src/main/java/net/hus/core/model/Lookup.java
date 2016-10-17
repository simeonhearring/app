package net.hus.core.model;

public class Lookup extends Model
{
  private String mGroup;
  private String mName;
  private String mAbbreviation;
  private Integer mSort;

  public String getGroup()
  {
    return mGroup;
  }

  public void setGroup(String inGroup)
  {
    mGroup = inGroup;
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
}