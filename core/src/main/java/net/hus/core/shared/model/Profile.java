package net.hus.core.shared.model;

import net.hus.core.shared.model.Lookup.Group;

public class Profile extends AbstractModel implements PageQuery, LookupXL
{
  private static final long serialVersionUID = -2062686028848352428L;

  private Type mType;
  private Page mPage;

  private String mUserName;
  private String mFirst;
  private String mMiddle;
  private String mLast;
  private String mPassword;
  private String mCss;

  private String[] mApps;

  private String mFvk;

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
    return mFvk != null ? mFvk : getId() + "";
  }

  @Override
  public String componentsName()
  {
    return mPage.getComponentsName();
  }

  public String getName()
  {
    String ret = null;
    if (Type.APP.equals(mType))
    {
      ret = mUserName;
    }
    else
    {
      // TODO should this format be in configurable?
      ret = mLast + ", " + mFirst + " " + mMiddle;
    }
    return ret;
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

  public String getFvk()
  {
    return mFvk;
  }

  public void setFvk(String inFvk)
  {
    mFvk = inFvk;
  }

  public Type getType()
  {
    return mType;
  }

  public void setType(Type inType)
  {
    mType = inType;
  }

  public String getCss()
  {
    return mCss;
  }

  public void setCss(String inCss)
  {
    mCss = inCss;
  }

  public void setCss(CssFileName inCss)
  {
    mCss = inCss.name();
  }

  public String[] getApps()
  {
    return mApps;
  }

  public void setApps(String[] inApps)
  {
    mApps = inApps;
  }

  public enum Type
  {
    NAV,
    APP,
    USER;
  }

  public enum Name
  {
    nHOME,
    nLOGIN,
    nADMIN
  }
}