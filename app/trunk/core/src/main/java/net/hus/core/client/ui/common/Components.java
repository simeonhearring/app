package net.hus.core.client.ui.common;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.client.common.Component;
import net.hus.core.model.TableKey;

public class Components<V>
{
  private List<Component<V>> mComponents = new ArrayList<>();

  public void add(Component<V> inComponent)
  {
    mComponents.add(inComponent);
  }

  public void setValue(V inValue)
  {
    for (Component<V> value : mComponents)
    {
      value.setValue(inValue);
    }
  }

  public void setFieldNameTk(String inFieldName, TableKey inTk)
  {
    for (Component<?> value : mComponents)
    {
      value.setLabel(inFieldName);
      value.setTableKey(inTk);
    }
  }

  public List<Component<V>> getComponents()
  {
    return mComponents;
  }
}