package net.hus.core.model;

public class Profile extends AbstractModel
{
  private static final long serialVersionUID = -2062686028848352428L;

  private String mUserName;
  private String mFirst;
  private String mMiddle;
  private String mLast;
  private String mPassword;

  private String mLandingPage;

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

  public String getLandingPage()
  {
    return mLandingPage;
  }

  public void setLandingPage(String inLandingPage)
  {
    mLandingPage = inLandingPage;
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
}