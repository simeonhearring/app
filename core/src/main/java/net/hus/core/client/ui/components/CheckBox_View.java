package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.CheckBox;

import net.hus.core.shared.model.Value;

public class CheckBox_View extends AbstractStatic_View<CheckBox>
{
  public CheckBox_View(CheckBox inComponent)
  {
    super(inComponent);
  }

  @Override
  public void setValue(String inValue)
  {
    mComponent.setValue(Boolean.valueOf(inValue));
  }

  @Override
  public void setValue(Value inValue)
  {
    mComponent.setValue(Boolean.valueOf(inValue.getValue()));
  }
}