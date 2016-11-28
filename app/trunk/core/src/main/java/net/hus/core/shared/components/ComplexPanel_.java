package net.hus.core.shared.components;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.shared.model.HasCollection;
import net.hus.core.shared.model.UIObject_;

public abstract class ComplexPanel_ extends UIObject_ implements HasCollection<UIObject_>
{
  private static final long serialVersionUID = -6861086723570356570L;

  private List<UIObject_> mCollection = new ArrayList<>();

  @Override
  public List<UIObject_> getCollection()
  {
    return mCollection;
  }

  @Override
  public boolean add(UIObject_ inUiObject)
  {
    mCollection.add(inUiObject);
    return true;
  }
}