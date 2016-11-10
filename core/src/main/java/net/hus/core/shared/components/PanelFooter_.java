package net.hus.core.shared.components;

import java.util.ArrayList;
import java.util.List;

public class PanelFooter_ extends UIObject_
{
  private static final long serialVersionUID = 2233532233811889030L;

  private List<UIObject_> mCollection = new ArrayList<>();

  public List<UIObject_> getCollection()
  {
    return mCollection;
  }

  public void add(UIObject_ inUiObject)
  {
    mCollection.add(inUiObject);
  }
}