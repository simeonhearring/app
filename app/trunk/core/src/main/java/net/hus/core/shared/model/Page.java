package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable
{
  private static final long serialVersionUID = -1612041487406778530L;

  public enum Layout
  {
    BLOG,
    WEB,
    MARKET,
    HOME,
    ADMIN,
    LOGIN;
  }

  private Layout mLayout;
  private String mComponentsName;

  Page()
  {
  }

  public Page(Layout inLayout, String inComponentName)
  {
    mLayout = inLayout;
    mComponentsName = inComponentName;
  }

  public Layout getLayout()
  {
    return mLayout;
  }

  public void setLayout(Layout inLayout)
  {
    mLayout = inLayout;
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
      MARR1L01(Page.Layout.MARKET),
      MARR1C01(Page.Layout.MARKET),
      MARR201(Page.Layout.MARKET),
      MARR202(Page.Layout.MARKET),
      MARR203(Page.Layout.MARKET),
      MARR204(Page.Layout.MARKET),
      MARR301(Page.Layout.MARKET),
      MARR302(Page.Layout.MARKET),
      MARR303(Page.Layout.MARKET),
      MARR304(Page.Layout.MARKET),
      MARR305(Page.Layout.MARKET),
      MARR306(Page.Layout.MARKET),

      BLOGL01(Page.Layout.BLOG),
      BLOGC01(Page.Layout.BLOG),

      WEBL01(Page.Layout.WEB),
      WEBC01(Page.Layout.WEB),
      WEBR01(Page.Layout.WEB),

      LOGINL01(Page.Layout.LOGIN),
      LOGINC01(Page.Layout.LOGIN),
      LOGINR01(Page.Layout.LOGIN),

      ADMINC01(Page.Layout.ADMIN);

      Page.Layout mLayout;

      private Name(Page.Layout inLayout)
      {
        mLayout = inLayout;
      }

      public static Page.Section.Name[] values(Page.Layout inLayout)
      {
        List<Name> list = new ArrayList<>();
        for (Name value : values())
        {
          if (inLayout.equals(value.mLayout))
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