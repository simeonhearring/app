package net.hus.core.client.ui.common;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.client.common.Component;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;

public class Components
{
  private List<Component> mComponents = new ArrayList<>();

  public void add(Component inComponent)
  {
    mComponents.add(inComponent);
  }

  public void setLabel(String inLabel)
  {
    for (Component value : mComponents)
    {
      value.setLabel(inLabel);
    }
  }

  public void setValue(Value inValue)
  {
    for (Component value : mComponents)
    {
      value.setValue(inValue);
    }
  }

  public void makeSaveable(String inFieldName, FieldTKG inFieldTKG, Field inField)
  {
    for (Component value : mComponents)
    {
      value.setLabel(inFieldName);
      value.setFieldTKG(inFieldTKG);
      value.setField(inField);
      value.addChangeHandler();
    }
  }

  public void makeClickable(FieldTKG inFieldTKG)
  {
    for (Component value : mComponents)
    {
      value.setFieldTKG(inFieldTKG);
      value.addChangeHandler();
    }
  }

  public List<Component> getComponents()
  {
    return mComponents;
  }
}