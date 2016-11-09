package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import net.hus.core.shared.model.Value;

public class TextBox_View extends Abstract_View<TextBox> implements ValueChangeHandler<String>
{
  public TextBox_View(TextBox inComponent)
  {
    super(inComponent);
  }

  @Override
  public void addChangeHandler()
  {
    mComponent.addValueChangeHandler(this);
    mComponent.addClickHandler(this);
  }

  @Override
  public void setValue(Value inValue)
  {
    mComponent.setValue(inValue.getValue());
  }

  @Override
  public void onValueChange(ValueChangeEvent<String> inEvent)
  {
    save(mComponent.getValue(), mComponent.getValue());
  }
}