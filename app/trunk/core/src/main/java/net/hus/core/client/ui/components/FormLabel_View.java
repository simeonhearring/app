package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.FormLabel;

import net.hus.core.shared.model.Value;

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

  @Override
  public void setValue(Value inValue)
  {
    mComponent.setText(inValue.getValue());
  }
}