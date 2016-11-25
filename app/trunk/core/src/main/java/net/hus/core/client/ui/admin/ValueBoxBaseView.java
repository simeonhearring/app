package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.constants.InputSize;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Callback;
import net.hus.core.client.common.UIObjectDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.components.ValueBoxBase_;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.model.YesNoNull;
import net.hus.core.shared.util.NumberUtil;
import net.hus.core.shared.util.StringUtil;

public class ValueBoxBaseView extends AbstractView implements UIObjectDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ValueBoxBaseView>
  {
  }

  @UiField
  Input mPlaceholder, mMaxLength;

  @UiField
  ListBox mSize, mAllowBlank, mAutoComplete;

  private ValueBoxBase_ mUiObject;

  public ValueBoxBaseView()
  {
    initWidget(BINDER.createAndBindUi(this));
    addEnumToListBox(InputSize.values(), mSize);

    addEnumDToListBox(YesNoNull.values(), mAllowBlank);
    addEnumDToListBox(YesNoNull.values(), mAutoComplete);
  }

  @Override
  public void setCallback(Callback<Boolean> inCallback)
  {
  }

  public ValueBoxBaseView(UIObject_ inUiObject)
  {
    this();
    set((ValueBoxBase_) inUiObject);
  }

  public void set(ValueBoxBase_ inUiObject)
  {
    mUiObject = inUiObject;
    mPlaceholder.setText(mUiObject.getPlaceholder());
    mMaxLength.setText(StringUtil.toValue(mUiObject.getMaxLength()));

    setEnumValueToListBox(mSize, mUiObject.getSize());
    setEnumValueToListBox(mAllowBlank, YesNoNull.value(mUiObject.getAllowBlank()));
    setEnumValueToListBox(mAutoComplete, YesNoNull.value(mUiObject.getAutoComplete()));
  }

  @UiHandler(
      {
        "mSize",
        "mAllowBlank",
        "mAutoComplete"
      })
  public void onChangeBind(ChangeEvent inEvent)
  {
    mUiObject.setSize(getEnumValueFromListBox(InputSize.values(), mSize));
    mUiObject.setAllowBlank(getEnumValueFromListBox(YesNoNull.values(), mAllowBlank).value());
    mUiObject.setAutoComplete(getEnumValueFromListBox(YesNoNull.values(), mAutoComplete).value());
  }

  @UiHandler(
      {
        "mPlaceholder",
        "mMaxLength"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    mUiObject.setPlaceholder(mPlaceholder.getText());
    mUiObject.setMaxLength(NumberUtil.toInteger(mMaxLength.getText()));
  }
}