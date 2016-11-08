package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

public class TextBox_View extends Abstract_View<TextBox, String>
implements ValueChangeHandler<String>
{
  public TextBox_View(TextBox inComponent)
  {
    super(inComponent);
  }

  @Override
  public void addChangeHandler()
  {
    mComponent.addValueChangeHandler(this);
  }

  @Override
  public void setValue(String inValue)
  {
    mComponent.setValue(inValue);
  }

  @Override
  public void onValueChange(ValueChangeEvent<String> inEvent)
  {
    save(mComponent.getValue(), mComponent.getValue());
  }
}