package net.hus.core.client.ui.common;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.client.common.StringView;

public class Views
{
  private List<StringView> mViews = new ArrayList<>();

  public void add(StringView inView)
  {
    mViews.add(inView);
  }

  public void setViews(String inValue)
  {
    for (StringView value : mViews)
    {
      value.setView(inValue);
    }
  }
}