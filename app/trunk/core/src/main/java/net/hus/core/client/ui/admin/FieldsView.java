package net.hus.core.client.ui.admin;

import java.util.Date;
import java.util.List;

import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.FormGroup;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.Row;
import org.gwtbootstrap3.client.ui.TabListItem;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.InputType;
import org.gwtbootstrap3.client.ui.form.validator.BlankValidator;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;
import org.gwtbootstrap3.client.ui.html.Span;
import org.gwtbootstrap3.extras.select.client.ui.OptGroup;
import org.gwtbootstrap3.extras.select.client.ui.Option;
import org.gwtbootstrap3.extras.select.client.ui.Select;
import org.gwtbootstrap3.extras.toggleswitch.client.ui.ToggleSwitch;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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
import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Page.Section;

public class FieldsView extends AbstractRowView
implements FieldsDisplay, ScheduledCommand, ValueChangeHandler<Boolean>, ChangeHandler
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
  Select mFields;

  @UiField
  Span mId, mName, mType;

  @UiField
  Span mLong, mShort;

  @UiField
  Span mStorageFormatEx;

  @UiField
  Span mLookupGroupText;

  @UiField
  Icon mSave0, mAdd0, mRefresh0, mPlus, mMinus;

  @UiField
  TextBox mAddName, mStorageFormat;

  @UiField
  ListBox mAddType, mLookupLocation, mHeadSize;

  @UiField
  FormGroup mAddNameGrp;

  @UiField
  TabListItem mNameTab, mDateTab, mArrayTab, mLookupTab;

  @UiField
  FlowPanel mLookupGroup, mArrayLabel;

  @UiField
  Span mSize;

  @UiField
  Input mBottomRow, mAltEven, mAltOdd;

  @UiField
  ToggleSwitch mAltColor;

  private Action mAction;

  public FieldsView()
  {
    initWidget(BINDER.createAndBindUi(this));
    mC01.setId(Section.Name.ADMINC01.name());

    addEnumDToListBox(Field.Type.values(), mAddType);

    addEnumDToListBox(Field.Lookup.Location.values(), mLookupLocation);

    addEnumToListBox(HeadingSize.values(), mHeadSize);

    mAddName.addValidator(new BlankValidator<String>());

    mAltColor.addValueChangeHandler(this);

    Scheduler.get().scheduleDeferred(this);
  }

  @Override
  public void execute()
  {
    addSpanHandler(DataType.DISPLAY_LONG, mLong);
    addSpanHandler(DataType.DISPLAY_SHORT, mShort);
  }

  @UiHandler(
      {
        "mAdd0",
        "mSave0",
        "mRefresh0",
        "mPlus",
        "mMinus"
      })
  public void onClickBind(ClickEvent inEvent)
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
    else if (mPlus.equals(inEvent.getSource()))
    {
      int size = mArrayLabel.getWidgetCount() + 1;
      addArrayLabels(size, true);
    }
    else if (mMinus.equals(inEvent.getSource()))
    {
      int size = mArrayLabel.getWidgetCount() - 1;
      addArrayLabels(size, true);
    }
  }

  @UiHandler(
      {
        "mFields",
        "mStorageFormat",
        "mAltEven",
        "mAltOdd",
        "mBottomRow"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    if (mFields.equals(inEvent.getSource()))
    {
      mAction.select(toLong(inEvent.getValue()));
    }
    else if (mStorageFormat.equals(inEvent.getSource()))
    {
      mAction.update(DataType.DATE_STORAGE_FORMAT, mStorageFormat.getText());
    }
    else if (mAltEven.equals(inEvent.getSource()))
    {
      mAction.update(DataType.ARRAY_ALTERNATE_COLOR_EVEN, mAltEven.getText());
    }
    else if (mAltOdd.equals(inEvent.getSource()))
    {
      mAction.update(DataType.ARRAY_ALTERNATE_COLOR_ODD, mAltOdd.getText());
    }
    else if (mBottomRow.equals(inEvent.getSource()))
    {
      mAction.update(DataType.ARRAY_BOTTOM_ROW_AT, mBottomRow.getText());
    }
  }

  @UiHandler(
      {
        "mLookupLocation",
        "mHeadSize"
      })
  public void onChangeBind(ChangeEvent inEvent)
  {
    if (mLookupLocation.equals(inEvent.getSource()))
    {
      mAction.update(DataType.LOOKUP_LOCATION, mLookupLocation.getSelectedValue());
    }
    else if (mHeadSize.equals(inEvent.getSource()))
    {
      mAction.update(DataType.ARRAY_HEADING_SIZE, mHeadSize.getSelectedValue());
    }
  }

  @UiHandler(
      {
        "mStorageFormat"
      })
  public void onKeyUpBind(KeyUpEvent inEvent)
  {
    formatExample(mStorageFormat, mStorageFormatEx);
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
    addArrayLabels(inField.getArraySize(), false);
    setEnumValueToListBox(inField.getArrayHeadSize(), mHeadSize);
    mAltEven.setValue(inField.getArrayAltEven());
    mAltOdd.setValue(inField.getArrayAltOdd());
    mAltColor.setValue(inField.isArrayAlt());
    mBottomRow.setValue(inField.getArrayBottomRow());

    // lookup
    addLookup(inField.getLookupParameters(), inField.getLookupLocation(), inField);
  }

  @Override
  public void onChange(ChangeEvent inEvent)
  {
    mAction.updateArray(getArrayLabels());
  }

  @Override
  public void onValueChange(ValueChangeEvent<Boolean> inEvent)
  {
    Object source = inEvent.getSource();
    if (mAltColor.equals(source))
    {
      mAction.update(DataType.ARRAY_ALTERNATE_COLOR, String.valueOf(mAltColor.getValue()));
    }
    else if (source instanceof CheckBox)
    {
      CheckBox box = (CheckBox) source;
      lookupGroup(inEvent.getValue(), box, box.getText() + ",");
      mAction.update(DataType.LOOKUP_PARAMETERS, mLookupGroupText.getText());
    }
  }

  @Override
  public void addLookup(List<String> inLookupGroups)
  {
    mLookupGroup.clear();
    for (String value : inLookupGroups)
    {
      CheckBox box = new CheckBox(value);
      box.setWordWrap(false);
      box.addValueChangeHandler(this);
      mLookupGroup.add(box);
    }
  }

  @Override
  public void clearFields()
  {
    mFields.clear();
  }

  @Override
  public void addFields(String inType, List<Lookup> inFields)
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
    mFields.add(type);
  }

  @Override
  public void refreshFields()
  {
    mFields.refresh();
  }

  @Override
  public Row[] getRow()
  {
    return new Row[]
        {
            mRow0
        };
  }

  private void addArrayLabels(int inSize, boolean inUpdate)
  {
    mSize.setText(String.valueOf(inSize));

    BlankValidator<String> bv = new BlankValidator<>();

    mArrayLabel.clear();
    for (int i = 0; i < inSize; i++)
    {
      Input input = new Input(InputType.TEXT);
      input.setValidateOnBlur(true);
      input.addValidator(bv);
      input.setPlaceholder("Enter label");
      input.setText(mAction.arrayLabel(i));
      input.addChangeHandler(this);
      mArrayLabel.add(input);
    }

    if (inUpdate)
    {
      mAction.updateArray(getArrayLabels());
    }
  }

  private void addSpanHandler(final DataType inType, final Span inSpan)
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

  private String[] getArrayLabels()
  {
    String[] ret = new String[mArrayLabel.getWidgetCount()];
    for (int i = 0; i < ret.length; i++)
    {
      ret[i] = ((Input) mArrayLabel.getWidget(i)).getText();
    }
    return ret;
  }

  private void formatExample(TextBox inText, Span inSpan)
  {
    inSpan.setText(DateTimeFormat.getFormat(inText.getText()).format(new Date()));
  }

  private void addLookup(String inLookupParameters, Location inLocation, Field inField)
  {
    setEnumValueToListBox(inLocation, mLookupLocation);

    mLookupGroupText.setText(null);

    if (inLookupParameters != null)
    {
      for (int i = 0; i < mLookupGroup.getWidgetCount(); i++)
      {
        CheckBox box = (CheckBox) mLookupGroup.getWidget(i);
        box.setValue(false);
        String option = box.getText() + ",";
        if (inLookupParameters.indexOf(option) != -1)
        {
          lookupGroup(true, box, option);
        }
      }
    }
  }

  private void lookupGroup(Boolean inChecked, CheckBox inBox, String inOption)
  {
    inBox.setValue(inChecked);
    if (inChecked)
    {
      mLookupGroupText.setText(mLookupGroupText.getText() + inOption);
    }
    else
    {
      mLookupGroupText.setText(mLookupGroupText.getText().replaceAll(inOption, ""));
    }
  }

  private static String toString(Long inId)
  {
    return String.valueOf(inId);
  }

  private static Long toLong(String inValue)
  {
    return Long.valueOf(inValue);
  }
}