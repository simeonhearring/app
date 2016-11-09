package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.Alert;

import net.hus.core.shared.model.Value;

public class Alert_View extends AbstractStatic_View<Alert>
{
  public Alert_View(Alert inComponent)
  {
    super(inComponent);
  }

  @Override
  public void setValue(Value inValue)
  {
    mComponent.setText(inValue.getValue());
  }
}