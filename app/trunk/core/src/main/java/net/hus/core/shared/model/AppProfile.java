package net.hus.core.shared.model;

public class AppProfile extends AbstractModel implements ComponentsQuery
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
}