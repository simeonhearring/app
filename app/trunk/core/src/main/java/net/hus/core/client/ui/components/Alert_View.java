package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.Alert;

public class Alert_View extends AbstractStatic_View<Alert>
{
  public Alert_View(Alert inComponent)
  {
    super(inComponent);
  }

  @Override
  public void setValue(String inValue)
  {
    mComponent.setText(inValue);
  }
}