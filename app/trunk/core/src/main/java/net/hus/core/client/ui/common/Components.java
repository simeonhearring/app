package net.hus.core.client.ui.common;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.client.common.Component;
import net.hus.core.model.Field;
import net.hus.core.model.TableFvk;

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

  public void setFieldNameTk(String inFieldName, TableFvk inTk, Field inField)
  {
    for (Component<?> value : mComponents)
    {
      value.setLabel(inFieldName);
      value.setTableFvk(inTk);
      value.setField(inField);
    }
  }

  public void setFvk(TableFvk inFvk)
  {
    for (Component<?> value : mComponents)
    {
      value.setTableFvk(inFvk);
    }
  }

  public List<Component<V>> getComponents()
  {
    return mComponents;
  }
}