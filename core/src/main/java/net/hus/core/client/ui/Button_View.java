package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.model.TableKey;

public class Button_View extends Abstract_View<String> implements ValueChangeHandler<String>
{
  private TextBox mView;

  public Button_View(String inKey, TextBox inView)
  {
    super(inKey);
    mView = inView;
  }

  @Override
  public void setTableKey(TableKey inTableKey)
  {
    super.setTableKey(inTableKey);
    mView.addValueChangeHandler(this);
  }

  @Override
  public void setView(String inValue)
  {
    mView.setValue(inValue);
  }

  @Override
  public Widget asWidget()
  {
    return mView;
  }

  @Override
  public void onValueChange(ValueChangeEvent<String> inEvent)
  {
    save(mView.getValue(), mView.getValue());
  }
}