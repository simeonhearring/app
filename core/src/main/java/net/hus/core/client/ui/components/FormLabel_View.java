package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.FormLabel;

import net.hus.core.client.ui.common.AbstractStatic_View;
import net.hus.core.shared.model.Value;

public class FormLabel_View extends AbstractStatic_View<FormLabel>
{
  public FormLabel_View(FormLabel inComponent)
  {
    super(inComponent);
  }

  @Override
  public void setValue(Value inValue)
  {
    mComponent.setText(inValue.getLabel());
  }
}