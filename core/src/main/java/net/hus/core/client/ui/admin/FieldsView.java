package net.hus.core.client.ui.admin;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.FormGroup;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.Row;
import org.gwtbootstrap3.client.ui.TabListItem;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.form.validator.BlankValidator;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;
import org.gwtbootstrap3.client.ui.html.Span;
import org.gwtbootstrap3.extras.select.client.ui.OptGroup;
import org.gwtbootstrap3.extras.select.client.ui.Option;
import org.gwtbootstrap3.extras.select.client.ui.Select;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.admin.FieldsDisplay;
import net.hus.core.client.ui.page.AbstractRowView;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.DataType;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Page.Section;

public class FieldsView extends AbstractRowView implements FieldsDisplay, ScheduledCommand
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

  @UiField
  Span mId, mName, mType;

  @UiField
  Span mLong, mShort;

  @UiField
  Span mStorageFormatEx;

  @UiField
  Span mLookupGroupText;

  @UiField
  Icon mSave0, mAdd0, mRefresh0;

  @UiField
  TextBox mAddName, mStorageFormat;

  @UiField
  ListBox mAddType, mLookupLocation;

  @UiField
  FormGroup mAddNameGrp;

  @UiField
  TabListItem mNameTab, mDateTab, mArrayTab, mLookupTab;

  @UiField
  FlowPanel mLookupGroup;

  private Action mAction;

  public FieldsView()
  {
    initWidget(BINDER.createAndBindUi(this));
    mC01.setId(Section.Name.ADMINC01.name());

    addEnumToListBox(Field.Type.values(), mAddType);

    mAddName.addValidator(new BlankValidator<String>());

    Scheduler.get().scheduleDeferred(this);
  }

  @Override
  public void execute()
  {
    addHandler(DataType.DISPLAY_LONG, mLong);
    addHandler(DataType.DISPLAY_SHORT, mShort);
  }

  @UiHandler(
      {
        "mAdd0",
        "mSave0",
        "mRefresh0"
      })
  public void onClicked(ClickEvent inEvent)
  {
    if (mAdd0.equals(inEvent.getSource()))
    {
      mAddNameGrp
      .setValidationState(mAction.add(mAddName.getText().trim(), mAddType.getSelectedValue()));
    }
    else if (mSave0.equals(inEvent.getSource()))
    {
      mAction.save();
    }
    else if (mRefresh0.equals(inEvent.getSource()))
    {
      mAction.refresh();
    }
  }

  @UiHandler(
      {
        "mSelect",
        "mStorageFormat"
      })
  public void onValueChange(ValueChangeEvent<String> inEvent)
  {
    if (mSelect.equals(inEvent.getSource()))
    {
      mAction.select(toLong(inEvent.getValue()));
    }
    else if (mStorageFormat.equals(inEvent.getSource()))
    {
      mAction.update(DataType.DATE_STORAGE_FORMAT, mStorageFormat.getText());
    }
  }

  @UiHandler(
      {
        "mLookupLocation"
      })
  public void onChange(ChangeEvent inEvent)
  {
    mAction.update(DataType.LOOKUP_LOCATION, mLookupLocation.getSelectedValue());
  }

  @UiHandler(
      {
        "mStorageFormat"
      })
  public void onKeyUp(KeyUpEvent inEvent)
  {
    formatExample(mStorageFormat, mStorageFormatEx);
  }

  private void formatExample(TextBox inText, Span inExample)
  {
    inExample.setText(DateTimeFormat.getFormat(inText.getText()).format(new Date()));
  }

  @Override
  public void setAction(Action inAction)
  {
    mAction = inAction;
  }

  @Override
  public void set(Field inField)
  {
    mNameTab.showTab();

    mDateTab.setVisible(inField.isDate());
    mArrayTab.setVisible(inField.isArray());
    mLookupTab.setVisible(inField.isLookup());

    // name
    mId.setText(String.valueOf(inField.getId()));
    mName.setText(inField.getName());
    mType.setText(inField.getType().name());

    // display
    mLong.setText(inField.getDisplayLong());
    mShort.setText(inField.getDisplayShort());

    // date
    mStorageFormat.setValue(inField.getDateFormat());
    formatExample(mStorageFormat, mStorageFormatEx);

    // array

    // lookup
    setEnumValueToListBox(inField.getLookupLocation(), mLookupLocation);

    mLookupGroupText.setText(null);

    String lookupParameters = inField.getLookupParameters();

    if (lookupParameters != null)
    {
      Iterator<Widget> it = mLookupGroup.iterator();
      while (it.hasNext())
      {
        CheckBox box = (CheckBox) it.next();
        box.setValue(false);
        if (lookupParameters.indexOf(box.getText() + ",") != -1)
        {
          check(true, box);
        }
      }
    }
  }

  @Override
  public void addLookup(List<String> inLookupGroups)
  {
    ValueChangeHandler<Boolean> handler = new ValueChangeHandler<Boolean>()
    {
      @Override
      public void onValueChange(ValueChangeEvent<Boolean> inEvent)
      {
        check(inEvent.getValue(), (CheckBox) inEvent.getSource());
        mAction.update(DataType.LOOKUP_PARAMETERS, mLookupGroupText.getText());
      }
    };

    mLookupGroup.clear();
    for (String value : inLookupGroups)
    {
      CheckBox box = new CheckBox(value);
      box.setWordWrap(false);
      box.addValueChangeHandler(handler);
      mLookupGroup.add(box);
    }

    addEnumToListBox(Field.Lookup.Location.values(), mLookupLocation);
  }

  private void addHandler(final DataType inType, final Span inSpan)
  {
    Event.sinkEvents(inSpan.getElement(), Event.ONBLUR);
    Event.setEventListener(inSpan.getElement(), new EventListener()
    {
      @Override
      public void onBrowserEvent(Event inEvent)
      {
        if (Event.ONBLUR == inEvent.getTypeInt())
        {
          mAction.update(inType, inSpan.getText());
        }
      }
    });

    inSpan.getElement().setAttribute("contenteditable", "true");
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
  public Row[] getRow()
  {
    return new Row[]
        {
            mRow0
        };
  }

  private void check(Boolean inChecked, CheckBox inBox)
  {
    inBox.setValue(inChecked);
    String value = inBox.getText() + ",";
    if (inChecked)
    {
      mLookupGroupText.setText(mLookupGroupText.getText() + value);
    }
    else
    {
      mLookupGroupText.setText(mLookupGroupText.getText().replaceAll(value, ""));
    }
  }
}