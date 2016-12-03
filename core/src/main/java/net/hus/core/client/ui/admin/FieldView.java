package net.hus.core.client.ui.admin;

import java.util.Date;
import java.util.List;

import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.FormGroup;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.Row;
import org.gwtbootstrap3.client.ui.TabListItem;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.InputType;
import org.gwtbootstrap3.client.ui.form.validator.BlankValidator;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;
import org.gwtbootstrap3.client.ui.html.Paragraph;
import org.gwtbootstrap3.client.ui.html.Span;
import org.gwtbootstrap3.extras.select.client.ui.OptGroup;
import org.gwtbootstrap3.extras.select.client.ui.Option;
import org.gwtbootstrap3.extras.select.client.ui.Select;
import org.gwtbootstrap3.extras.toggleswitch.client.ui.ToggleSwitch;

import com.google.gwt.core.client.GWT;
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
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.admin.FieldDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.DataType;
import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.shared.model.Lookup;

public class FieldView extends AbstractView
implements FieldDisplay, ValueChangeHandler<Boolean>, ChangeHandler
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, FieldView>
  {
  }

  @UiField
  Select mFields;

  @UiField
  Paragraph mId, mName, mType;

  @UiField
  Span mSize;

  @UiField
  Paragraph mStorageFormatEx, mLookupGroupText;

  @UiField
  Input mLong, mShort, mAddName, mStorageFormat;

  @UiField
  Icon mSave0, mSave1, mSave2, mSave3, mRefresh0, mRefresh1, mRefresh2, mRefresh3;

  @UiField
  Icon mAdd0, mPlus, mMinus;

  @UiField
  ListBox mAddType, mLookupLocation, mHeadSize, mFvt, mFgg;

  @UiField
  FormGroup mAddNameGrp, mTableFieldsGrp, mCTypesGrp;

  @UiField
  Row mTKGRow;

  @UiField
  TabListItem mNameTab, mDateTab, mArrayTab, mLookupTab;

  @UiField
  FlowPanel mLookupGroup, mArrayLabel, mTableFields, mCTypes;

  @UiField
  Input mBottomRow, mAltEven, mAltOdd;

  @UiField
  ToggleSwitch mAltColor;

  private Action mAction;

  public FieldView()
  {
    initWidget(BINDER.createAndBindUi(this));

    addEnumDToListBox(Field.Type.values(), mAddType);

    addEnumDToListBox(Field.Lookup.Location.values(), mLookupLocation);

    addEnumToListBox(HeadingSize.values(), mHeadSize);

    mAddName.addValidator(new BlankValidator<String>());

    mAltColor.addValueChangeHandler(this);
  }

  @UiHandler(
      {
        "mSave0",
        "mSave1",
        "mSave2",
        "mSave3",
        "mRefresh0",
        "mRefresh1",
        "mRefresh2",
        "mRefresh3",
        "mAdd0",
        "mPlus",
        "mMinus"
      })
  public void onClickBind(ClickEvent inEvent)
  {
    if (mAdd0.equals(inEvent.getSource()))
    {
      mAddNameGrp.setValidationState(
          mAction.addField(mAddName.getText().trim(), mAddType.getSelectedValue()));
    }
    else if (isSave(inEvent.getSource()))
    {
      mAction.saveField();
    }
    else if (isRefresh(inEvent.getSource()))
    {
      mAction.refreshFields();
    }
    else if (mPlus.equals(inEvent.getSource()))
    {
      int size = mArrayLabel.getWidgetCount() + 1;
      addArrayLabels(size, true);
      addTableFields(size, true);
      addCTypes(size, true);
    }
    else if (mMinus.equals(inEvent.getSource()))
    {
      int size = mArrayLabel.getWidgetCount() - 1;
      addArrayLabels(size, true);
      addTableFields(size, true);
      addCTypes(size, true);
    }
  }

  private boolean isSave(Object inSource)
  {
    return mSave0.equals(inSource) || mSave1.equals(inSource) || mSave2.equals(inSource)
        || mSave3.equals(inSource);
  }

  private boolean isRefresh(Object inSource)
  {
    return mRefresh0.equals(inSource) || mRefresh1.equals(inSource) || mRefresh2.equals(inSource)
        || mRefresh3.equals(inSource);
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
    else if (mLong.equals(inEvent.getSource()))
    {
      mAction.update(DataType.DISPLAY_LONG, mLong.getText());
    }
    else if (mShort.equals(inEvent.getSource()))
    {
      mAction.update(DataType.DISPLAY_SHORT, mShort.getText());
    }
    else if (mBottomRow.equals(inEvent.getSource()))
    {
    }
  }

  @UiHandler(
      {
        "mLookupLocation",
        "mHeadSize",
        "mFvt",
        "mFgg"
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
    else if (mFvt.equals(inEvent.getSource()))
    {
      if (mAction.isTable())
      {
        mAction.update(DataType.ARRAY_FVK, mFvt.getSelectedValue());
      }
    }
    else if (mFgg.equals(inEvent.getSource()))
    {
      if (mAction.isTable())
      {
        mAction.update(DataType.ARRAY_FGG, mFgg.getSelectedValue());
      }
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
    mArrayTab.setVisible(inField.isArray() || inField.isTable());
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
    addArrayLabels(inField.arraySize(), false);
    setSelectedIndex(mHeadSize, inField.arrayHeadSize());
    mAltEven.setValue(inField.getArrayAltEven());
    mAltOdd.setValue(inField.getArrayAltOdd());
    mAltColor.setValue(inField.isArrayAlt());
    mBottomRow.setValue(inField.getArrayBottomRow());

    // table
    addTableFields(inField.arraySize(), false);
    addCTypes(inField.arraySize(), false);
    addFvt(mAction.getFvt(), inField.getArrayFvt());
    addFgg(mAction.getFgg(), inField.getArrayFgg());
    mTKGRow.setVisible(mAction.isTable());

    // lookup
    addLookup(inField.lookupParameters(), inField.lookupLocation(), inField);

    mFields.setValue(null);
  }

  @Override
  public void onChange(ChangeEvent inEvent)
  {
    mAction.updateArray(getArrayLabels());
    if (mTableFieldsGrp.isVisible())
    {
      mAction.updateTable(getTableFields());
      mAction.updateCTypes(getCTypes());
    }
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
  public void addLookup(List<Lookup> inLookupGroups)
  {
    mLookupGroup.clear();
    for (Lookup value : inLookupGroups)
    {
      CheckBox box = new CheckBox(value.getName());
      box.setWordWrap(false);
      box.addValueChangeHandler(this);
      mLookupGroup.add(box);
    }
  }

  public void addFvt(List<Lookup> inLookup, String inFvt)
  {
    mFvt.clear();
    if (mAction.isTable())
    {
      addLookupNameToListBox(mFvt, inLookup);
      setSelectedIndex(mFvt, inFvt);
    }
  }

  public void addFgg(List<Lookup> inLookup, String inFgg)
  {
    mFgg.clear();
    if (mAction.isTable())
    {
      addLookupNameToListBox(mFgg, inLookup);
      setSelectedIndex(mFgg, inFgg);
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
    mFields.setValue(null);
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

  private void addTableFields(int inSize, boolean inUpdate)
  {
    if (mAction.isTable())
    {
      mTableFields.clear();
      for (int i = 0; i < inSize; i++)
      {
        ListBox box = new ListBox();
        addLookupAltToListBox(box, mAction.getFields());
        setSelectedIndex(box, String.valueOf(mAction.fieldId(i)));
        box.addChangeHandler(this);
        mTableFields.add(box);
      }

      if (inUpdate)
      {
        mAction.updateTable(getTableFields());
      }
    }
    mTableFieldsGrp.setVisible(mAction.isTable());
  }

  private void addCTypes(int inSize, boolean inUpdate)
  {
    if (mAction.isTable())
    {
      mCTypes.clear();
      for (int i = 0; i < inSize; i++)
      {
        ListBox box = new ListBox();
        addEnumDToListBox(Components.Type.values(), box);
        setSelectedIndex(box, mAction.cType(i));
        box.addChangeHandler(this);
        mCTypes.add(box);
      }

      if (inUpdate)
      {
        mAction.updateCTypes(getCTypes());
      }
    }
    mCTypesGrp.setVisible(mAction.isTable());
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

  private Long[] getTableFields()
  {
    Long[] ret = new Long[mTableFields.getWidgetCount()];
    for (int i = 0; i < ret.length; i++)
    {
      ret[i] = getListBoxLongValue((ListBox) mTableFields.getWidget(i));
    }
    return ret;
  }

  private Components.Type[] getCTypes()
  {
    Components.Type[] ret = new Components.Type[mCTypes.getWidgetCount()];
    for (int i = 0; i < ret.length; i++)
    {
      ret[i] = getEnumValueFromListBox(Components.Type.values(), (ListBox) mCTypes.getWidget(i));
    }
    return ret;
  }

  private void formatExample(Input inText, Paragraph inPar)
  {
    inPar.setText(DateTimeFormat.getFormat(inText.getText()).format(new Date()));
  }

  private void addLookup(String inLookupParameters, Location inLocation, Field inField)
  {
    setSelectedIndex(mLookupLocation, inLocation);

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
}