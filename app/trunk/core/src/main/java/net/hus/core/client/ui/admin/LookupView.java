package net.hus.core.client.ui.admin;

import java.util.List;

import org.gwtbootstrap3.client.ui.gwt.FlowPanel;
import org.gwtbootstrap3.client.ui.html.Paragraph;
import org.gwtbootstrap3.extras.select.client.ui.Option;
import org.gwtbootstrap3.extras.select.client.ui.Select;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.admin.LookupDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Page.Section.Name;

public class LookupView extends AbstractView implements LookupDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, LookupView>
  {
  }

  @UiField
  Select mLookups;

  @UiField
  FlowPanel mValues;

  private Action mAction;

  public LookupView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public void setAction(Action inAction)
  {
    mAction = inAction;
  }

  @Override
  public void add(Name inSection, IsWidget inComponent)
  {
    // do nothing
  }

  @UiHandler(
  {
      "mLookups"
  })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    if (mLookups.equals(inEvent.getSource()))
    {
      mAction.select(mLookups.getSelectedItem().getValue());
    }
  }

  @Override
  public void addLookupGroups(List<Lookup> inLookupGroups)
  {
    mLookups.clear();
    for (Lookup value : inLookupGroups)
    {
      Option field = new Option();
      field.setText(value.getDisplay());
      field.setValue(value.getName());
      field.setId(value.getId().toString());
      mLookups.add(field);
    }
    mLookups.refresh();
    mLookups.setValue(null);
  }

  @Override
  public void addValues(List<Lookup> inLookupGroup)
  {
    mValues.clear();
    for (Lookup value : inLookupGroup)
    {
      Paragraph para = new Paragraph();

      para.setText(value.getDisplay());
      para.setId(value.getId().toString());
      mValues.add(para);

      EventListener listner = new EventListener()
      {
        @Override
        public void onBrowserEvent(Event inEvent)
        {
          if (Event.ONBLUR == inEvent.getTypeInt())
          {
            LookupView.this.notify("Blur");
          }
        }
      };
      addHandler(Event.ONBLUR, para.getElement(), listner);
    }
    mLookups.setValue(null);
  }
}