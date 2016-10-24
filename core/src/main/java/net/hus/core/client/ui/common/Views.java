package net.hus.core.client.ui.common;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.client.common.View;

public class Views
{
  private List<View> mViews = new ArrayList<>();

  public void add(View inView)
  {
    mViews.add(inView);
  }

  public void setViews(String inValue)
  {
    for (View value : mViews)
    {
      value.setView(inValue);
    }
  }
}