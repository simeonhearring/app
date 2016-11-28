package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.hus.core.shared.util.StringUtil;

public class Page implements Serializable
{
  private static final long serialVersionUID = -1612041487406778530L;

  public enum Layout
  {
    // BLOG,
    // MARKET,
    HOME,
    LOGIN,
    ADMIN,
    WEB;
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

    public enum Name implements EnumDisplay
    {
      LEFT_01(Page.Layout.LOGIN, Page.Layout.HOME, Page.Layout.WEB),
      LEFT_02(),
      LEFT_03(),
      LEFT_04(),
      LEFT_05(),

      CENTER_01(Page.Layout.LOGIN, Page.Layout.HOME, Page.Layout.WEB, Page.Layout.ADMIN),
      CENTER_02(),
      CENTER_03(),
      CENTER_04(),
      CENTER_05(),

      RIGHT_01(Page.Layout.LOGIN, Page.Layout.HOME, Page.Layout.WEB),
      RIGHT_02(),
      RIGHT_03(),
      RIGHT_04(),
      RIGHT_05(),
      ;

      Page.Layout[] mLayout;

      private Name()
      {
      }

      private Name(Page.Layout... inLayout)
      {
        mLayout = inLayout;
      }

      @Override
      public String display()
      {
        return StringUtil.toTitle(name().replaceAll("_", " "));
      }

      public static Section.Name[] values(Page.Layout inLayout)
      {
        List<Name> list = new ArrayList<>();
        for (Name value : values())
        {
          if (value.mLayout != null)
          {
            for (Layout lvalue : value.mLayout)
            {
              if (inLayout.equals(lvalue))
              {
                list.add(value);
              }
            }
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