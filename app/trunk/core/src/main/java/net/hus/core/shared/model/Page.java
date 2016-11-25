package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable
{
  private static final long serialVersionUID = -1612041487406778530L;

  public enum Name
  {
    BLOG,
    WEB,
    MARKET,
    ADMIN,
    LOGIN;
  }

  private Name mName;
  private String mComponentsName;

  Page()
  {
  }

  public Page(Name inName, String inComponentName)
  {
    mName = inName;
    mComponentsName = inComponentName;
  }

  public Name getName()
  {
    return mName;
  }

  public void setName(Name inName)
  {
    mName = inName;
  }

  public String getComponentsName()
  {
    return mComponentsName;
  }

  public void setComponentsName(String inComponentsName)
  {
    mComponentsName = inComponentsName;
  }

  public static class Section implements Serializable
  {
    private static final long serialVersionUID = 6166844602372421962L;

    public enum Name
    {
      // TODO remove as enum. make lookup.
      MARR1L01(Page.Name.MARKET),
      MARR1C01(Page.Name.MARKET),
      MARR201(Page.Name.MARKET),
      MARR202(Page.Name.MARKET),
      MARR203(Page.Name.MARKET),
      MARR204(Page.Name.MARKET),
      MARR301(Page.Name.MARKET),
      MARR302(Page.Name.MARKET),
      MARR303(Page.Name.MARKET),
      MARR304(Page.Name.MARKET),
      MARR305(Page.Name.MARKET),
      MARR306(Page.Name.MARKET),

      BLOGL01(Page.Name.BLOG),
      BLOGC01(Page.Name.BLOG),

      WEBL01(Page.Name.WEB),
      WEBC01(Page.Name.WEB),
      WEBR01(Page.Name.WEB),

      LOGINL01(Page.Name.LOGIN),
      LOGINC01(Page.Name.LOGIN),
      LOGINR01(Page.Name.LOGIN),

      ADMINC01(Page.Name.ADMIN);

      Page.Name mPage;

      private Name(Page.Name inPage)
      {
        mPage = inPage;
      }

      public static Page.Section.Name[] values(Page.Name inPage)
      {
        List<Name> list = new ArrayList<>();
        for (Name value : values())
        {
          if (inPage.equals(value.mPage))
          {
            list.add(value);
          }
        }

        Name[] ret = new Name[list.size()];
        for (int i = 0; i < ret.length; i++)
        {
          ret[i] = list.get(i);
        }
        return ret;
      }
    }
  }
}