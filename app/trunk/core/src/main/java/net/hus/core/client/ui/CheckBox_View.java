package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.CheckBox;

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
}