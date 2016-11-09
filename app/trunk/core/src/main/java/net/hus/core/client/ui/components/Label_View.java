package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.Label;

import net.hus.core.shared.model.Value;

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

  @Override
  public void setValue(Value inValue)
  {
    mComponent.setText(inValue.getValue());
  }
}