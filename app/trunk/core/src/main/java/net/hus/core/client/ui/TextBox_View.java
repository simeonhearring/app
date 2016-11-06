package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import net.hus.core.model.TableFvk;

public class TextBox_View extends Abstract_View<TextBox, String>
    implements ValueChangeHandler<String>
{
  public TextBox_View(String inKey, TextBox inComponent)
  {
    super(inKey, inComponent);
  }

  @Override
  public void setTableFvk(TableFvk inTableKey)
  {
    super.setTableFvk(inTableKey);
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