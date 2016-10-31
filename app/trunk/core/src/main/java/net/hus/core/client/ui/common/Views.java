package net.hus.core.client.ui.common;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.client.common.Component;
import net.hus.core.model.TableKey;

public class Views<T>
{
  private List<Component<T>> mViews = new ArrayList<>();

  public void add(Component<T> inView)
  {
    mViews.add(inView);
  }

  public void setViews(T inValue)
  {
    for (Component<T> value : mViews)
    {
      value.setValue(inValue);
    }
  }

  public void setName(String inValue, TableKey inTk)
  {
    for (Component<T> value : mViews)
    {
      value.setFieldName(inValue);
      value.setTableKey(inTk);
    }
  }

  public List<Component<T>> getViews()
  {
    return mViews;
  }
}