package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.FormLabel;

public class FormLabel_View extends AbstractStatic_View<FormLabel>
{
  public FormLabel_View(FormLabel inComponent)
  {
    super(inComponent);
  }

  @Override
  public void setValue(String inValue)
  {
    mComponent.setText(inValue);
  }
}