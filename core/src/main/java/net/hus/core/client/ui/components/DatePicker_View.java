package net.hus.core.client.ui.components;

import java.util.Date;

import org.gwtbootstrap3.extras.datepicker.client.ui.DatePicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.shared.model.Field;

public class DatePicker_View extends AbstractComposite_View<DatePicker, String>
implements ValueChangeHandler<Date>
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, DatePicker_View>
  {
  }

  @UiField
  DatePicker mComponent;

  private String mDateFormat = "yyyy-MM-dd";

  public DatePicker_View()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public void setField(Field inField)
  {
    super.setField(inField);
    mComponent.addValueChangeHandler(this);
    String format = mField.getDateFormat();
    if (format != null)
    {
      mDateFormat = format;
    }
  }

  @Override
  public DatePicker getComponent()
  {
    return mComponent;
  }

  @Override
  public void setValue(String inValue)
  {
    mComponent.setValue(DateTimeFormat.getFormat(mDateFormat).parse(inValue));
  }

  @Override
  public void onValueChange(ValueChangeEvent<Date> inEvent)
  {
    String value = DateTimeFormat.getFormat(mDateFormat).format(mComponent.getValue());
    save(value, value);
  }
}