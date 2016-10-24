package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.Input;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Widget;

public class Input_View extends Abstract_View implements ValueChangeHandler<String>
{
  private Input mView;

  public Input_View(String inKey, Input inView)
  {
    super(inKey);
    mView = inView;
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