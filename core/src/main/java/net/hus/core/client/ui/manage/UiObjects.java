package net.hus.core.client.ui.manage;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.client.common.View;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;

public class UiObjects
{
  private List<View> mComponents = new ArrayList<>();

  public void add(View inComponent)
  {
    mComponents.add(inComponent);
  }

  public void setLabel(String inLabel)
  {
    for (View value : mComponents)
    {
      value.setLabel(inLabel);
    }
  }

  public void setValue(Value inValue)
  {
    for (View value : mComponents)
    {
      value.setValue(inValue);
    }
  }

  public void addField(String inFieldName, FieldTKG inFieldTKG, Field inField, int inPos)
  {
    for (View value : mComponents)
    {
      value.setLabel(inFieldName);
      value.setFieldTKG(inFieldTKG);
      value.setField(inField);
      value.setPos(inPos);
    }
  }

  public void makeSaveable()
  {
    for (View value : mComponents)
    {
      value.addChangeHandler();
    }
  }

  public void makeClickable(FieldTKG inFieldTKG)
  {
    for (View value : mComponents)
    {
      value.setFieldTKG(inFieldTKG);
      value.addChangeHandler();
    }
  }

  public List<View> getComponents()
  {
    return mComponents;
  }
}