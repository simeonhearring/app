package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.model.TableKey;

public class TextBox_View extends Abstract_View<String> implements ValueChangeHandler<String>
{
  private TextBox mView;

  public TextBox_View(TableKey inTk, String inKey, TextBox inView)
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