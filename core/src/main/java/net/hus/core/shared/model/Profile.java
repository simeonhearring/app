package net.hus.core.shared.model;

import net.hus.core.shared.model.Lookup.Group;

public class Profile extends AbstractModel implements ComponentsQuery, LookupXL
{
  private static final long serialVersionUID = -2062686028848352428L;

  private Page mPage;

  private String mUserName;
  private String mFirst;
  private String mMiddle;
  private String mLast;
  private String mPassword;

  public Page getPage()
  {
    return mPage;
  }

  public void setPage(Page inPage)
  {
    mPage = inPage;
  }

  public String getFirst()
  {
    return mFirst;
  }

  public void setFirst(String inFirst)
  {
    mFirst = inFirst;
  }

  public String getMiddle()
  {
    return mMiddle;
  }

  public void setMiddle(String inMiddle)
  {
    mMiddle = inMiddle;
  }

  public String getLast()
  {
    return mLast;
  }

  public void setLast(String inLast)
  {
    mLast = inLast;
  }

  public String getUserName()
  {
    return mUserName;
  }

  public void setUserName(String inUserName)
  {
    mUserName = inUserName;
  }

  public String getPassword()
  {
    return mPassword;
  }

  public void setPassword(String inPassword)
  {
    mPassword = inPassword;
  }

  @Override
  public String fvk()
  {
    return getId() + "";
  }

  @Override
  public String componentsName()
  {
    return mPage.getComponentsName();
  }

  public String getName()
  {
    // TODO should this format be in configurable?
    return mLast + ", " + mFirst + " " + mMiddle;
  }

  @Override
  public Group groupXL()
  {
    return Group.PROFILE;
  }

  @Override
  public String nameXL()
  {
    return mUserName;
  }

  @Override
  public String displayXL()
  {
    return getName();
  }
}