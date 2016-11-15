package net.hus.core.client.ui.admin;

import java.util.List;

import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Row;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;
import org.gwtbootstrap3.extras.select.client.ui.OptGroup;
import org.gwtbootstrap3.extras.select.client.ui.Option;
import org.gwtbootstrap3.extras.select.client.ui.Select;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.admin.FieldsDisplay;
import net.hus.core.client.ui.page.AbstractRowView;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Page.Section;

public class FieldsView extends AbstractRowView implements FieldsDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, FieldsView>
  {
  }

  @UiField
  Row mRow0;

  @UiField
  Column mL01, mC01, mR01;

  @UiField
  Select mSelect;

  public FieldsView()
  {
    initWidget(BINDER.createAndBindUi(this));

    mC01.setId(Section.Name.ADMINC01.name());
  }

  @Override
  public void addValueChangeHandler(ValueChangeHandler<String> inHandler)
  {
    mSelect.addValueChangeHandler(inHandler);
  }

  @Override
  public void add(Field inField)
  {
    Notify.notify(inField.getName());
  }

  @Override
  public void clear()
  {
    mSelect.clear();
  }

  @Override
  public void add(String inType, List<Lookup> inFields)
  {
    OptGroup type = new OptGroup();
    type.setLabel(inType);

    for (Lookup value : inFields)
    {
      Option field = new Option();
      field.setText(value.getDisplay());
      field.setValue(toString(value.getAltId()));
      type.add(field);
    }
    mSelect.add(type);
  }

  private static String toString(Long inId)
  {
    return String.valueOf(inId);
  }

  private static Long toLong(String inValue)
  {
    return Long.valueOf(inValue);
  }

  @Override
  public void refresh()
  {
    mSelect.refresh();
  }

  @Override
  public Long getFieldId(ValueChangeEvent<String> inEvent)
  {
    return toLong(inEvent.getValue());
  }

  @Override
  public Row[] getRow()
  {
    return new Row[]
        {
            mRow0
        };
  }
}