package net.hus.core.client.ui.common;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.client.common.View;

public class Views<T>
{
  private List<View<T>> mViews = new ArrayList<>();

  public void add(View<T> inView)
  {
    mViews.add(inView);
  }

  public void setViews(T inValue)
  {
    for (View<T> value : mViews)
    {
      value.setView(inValue);
    }
  }

  public void setName(String inValue)
  {
    for (View<T> value : mViews)
    {
      value.setFieldName(inValue);
    }
  }
}