package net.hus.core.client.ui.components;

import org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.shared.model.Field;

public class Typeahead_View extends AbstractComposite_View<Typeahead<String>, String>
    implements ValueChangeHandler<String>
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, Typeahead_View>
  {
  }

  @UiField
  Typeahead<String> mComponent;

  public Typeahead_View()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public void setField(Field inField)
  {
    super.setField(inField);
    mComponent.addValueChangeHandler(this);
  }

  @Override
  public Typeahead<String> getComponent()
  {
    return mComponent;
  }

  @Override
  public void setValue(String inValue)
  {
    mComponent.setValue(inValue);
  }

  @Override
  public void onValueChange(ValueChangeEvent<String> inEvent)
  {
  }
}