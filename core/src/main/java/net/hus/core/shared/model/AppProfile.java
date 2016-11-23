package net.hus.core.shared.model;

import net.hus.core.shared.model.Lookup.Group;

public class AppProfile extends AbstractModel implements ComponentsQuery, LookupXL
{
  private static final long serialVersionUID = -2543608623283163125L;

  private Page mPage;
  private String mFvk;

  public Page getPage()
  {
    return mPage;
  }

  public void setPage(Page inPage)
  {
    mPage = inPage;
  }

  @Override
  public String fvk()
  {
    return mFvk;
  }

  public void setFvk(String inFvk)
  {
    mFvk = inFvk;
  }

  @Override
  public String componentsName()
  {
    return mPage.getComponentsName();
  }

  @Override
  public Group groupXL()
  {
    return Group.APP_PROFILE;
  }

  @Override
  public String nameXL()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String displayXL()
  {
    // TODO Auto-generated method stub
    return null;
  }
}