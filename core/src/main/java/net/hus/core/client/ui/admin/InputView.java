package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.InputType;
import org.gwtbootstrap3.client.ui.html.Paragraph;

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
import net.hus.core.shared.components.Input_;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Page.Layout;
import net.hus.core.shared.model.UIObject_;

public class InputView extends AbstractView implements UIObjectDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, InputView>
  {
  }

  @UiField
  Paragraph mName;

  @UiField
  ListBox mType;

  @UiField
  Input mMin, mMax;

  @UiField
  ValueBoxBaseView mValueBoxBase;

  @UiField
  UIObjectView mUIObject;

  @UiField
  ActionView mAction0, mAction1;

  private Input_ mUiObject;

  public InputView()
  {
    initWidget(BINDER.createAndBindUi(this));
    addEnumToListBox(InputType.values(), mType);
  }

  public InputView(UIObject_ inUiObject, Fields inFields, boolean inChild, Layout inPage)
  {
    this();
    mUIObject.setUpSection(inChild, inPage);
    mUIObject.setFields(Field.Component.FV00_, inFields);
    set((Input_) inUiObject);
  }

  @Override
  public void setCallback(Callback<IconType> inCallback)
  {
    mAction0.setCallback(inCallback);
    mAction1.setCallback(inCallback);
  }

  public void set(Input_ inUiObject)
  {
    mUiObject = inUiObject;
    mName.setText(mUiObject.getSimpleName());
    mMin.setText(mUiObject.getMin());
    mMax.setText(mUiObject.getMax());
    setSelectedIndex(mType, mUiObject.getType());

    mValueBoxBase.set(mUiObject);
    mUIObject.set(mUiObject);
  }

  @UiHandler(
      {
        "mType"
      })
  public void onChangeBind(ChangeEvent inEvent)
  {
    mUiObject.setType(getEnumValueFromListBox(InputType.values(), mType));
  }

  @UiHandler(
      {
        "mMin",
        "mMax"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    mUiObject.setMin(mMin.getText());
    mUiObject.setMax(mMax.getText());
  }
}