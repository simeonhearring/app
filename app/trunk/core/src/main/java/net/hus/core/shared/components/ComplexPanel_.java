package net.hus.core.shared.components;

import java.util.ArrayList;
import java.util.List;

public class ComplexPanel_ extends UIObject_
{
  private static final long serialVersionUID = -6861086723570356570L;

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