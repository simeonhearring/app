package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.Badge;

public class Badge_View extends AbstractStatic_View<Badge>
{
  public Badge_View(Badge inComponent)
  {
    super(inComponent);
  }

  @Override
  public void setValue(String inValue)
  {
    mComponent.setText(inValue);
  }
}