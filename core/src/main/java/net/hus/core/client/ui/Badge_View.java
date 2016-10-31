package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.Badge;

public class Badge_View extends AbstractString_View<Badge>
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