package net.hus.core.client.ui.select;

import java.util.List;

import org.gwtbootstrap3.extras.select.client.ui.Option;
import org.gwtbootstrap3.extras.select.client.ui.Select;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.select.SelectFVKDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.model.Lookup;

public class SelectFVKView extends AbstractView implements SelectFVKDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, SelectFVKView>
  {
  }

  @UiField
  Select mSelect;

  private Action mAction;

  public SelectFVKView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @UiHandler(
      {
        "mSelect"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    if (mSelect.equals(inEvent.getSource()))
    {
      Option selectedItem = mSelect.getSelectedItem();
      mAction.select(selectedItem.getId());
    }
  }

  @Override
  public void setAction(Action inAction)
  {
    mAction = inAction;
  }

  @Override
  public void addKeys(List<Lookup> inKeys)
  {
    mSelect.clear();
    for (Lookup value : inKeys)
    {
      Option field = new Option();
      field.setText(value.getDisplay());
      field.setId(value.getAltId().toString());
      mSelect.add(field);
    }
    mSelect.refresh();
    mSelect.setValue(null);
  }
}