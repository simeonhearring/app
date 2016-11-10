package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.Input;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import net.hus.core.client.ui.common.Abstract_View;
import net.hus.core.shared.model.Value;

public class Input_View extends Abstract_View<Input> implements ValueChangeHandler<String>
{
  public Input_View(Input inComponent)
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