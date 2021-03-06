package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.Badge;

import net.hus.core.client.ui.common.AbstractStatic_View;
import net.hus.core.shared.model.Value;

public class Badge_View extends AbstractStatic_View<Badge>
{
  public Badge_View(Badge inComponent)
  {
    super(inComponent);
  }

  @Override
  public void setValue(Value inValue)
  {
    mComponent.setText(inValue.getValue());
  }
}