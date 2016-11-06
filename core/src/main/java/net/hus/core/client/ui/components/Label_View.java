package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.Label;

public class Label_View extends AbstractStatic_View<Label>
{
  public Label_View(Label inComponent)
  {
    super(inComponent);
  }

  @Override
  public void setValue(String inValue)
  {
    mComponent.setText(inValue);
  }
}