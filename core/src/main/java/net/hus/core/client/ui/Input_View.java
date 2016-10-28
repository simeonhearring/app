package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.Input;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.model.TableKey;

public class Input_View extends Abstract_View<String> implements ValueChangeHandler<String>
{
  private Input mView;

  public Input_View(TableKey inTk, String inKey, Input inView)
  {
    super(inTk, inKey);
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