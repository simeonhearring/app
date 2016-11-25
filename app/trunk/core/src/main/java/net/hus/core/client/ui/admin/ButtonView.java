package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.constants.BadgePosition;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.Toggle;
import org.gwtbootstrap3.client.ui.html.Paragraph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Callback;
import net.hus.core.client.common.UIObjectDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.components.Button_;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.model.YesNoNull;

public class ButtonView extends AbstractView implements UIObjectDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ButtonView>
  {
  }

  @UiField
  Paragraph mName;

  @UiField
  Input mText, mCommandName, mBadgeText;

  @UiField
  ListBox mType, mSize, mCaret, mDataToggle, mBadgePosition;

  @UiField
  ListBox mActive, mEnabled;

  @UiField
  UIObjectView mUIObject;

  @UiField
  ActionView mAction0, mAction1;

  private Button_ mUiObject;

  public ButtonView()
  {
    initWidget(BINDER.createAndBindUi(this));

    addEnumToListBox(ButtonType.values(), mType);
    addEnumToListBox(ButtonSize.values(), mSize, true);
    addEnumToListBox(Toggle.values(), mDataToggle, true);
    addEnumToListBox(BadgePosition.values(), mBadgePosition, true);
    addEnumDToListBox(YesNoNull.values(), mCaret);
    addEnumDToListBox(YesNoNull.values(), mActive);
    addEnumDToListBox(YesNoNull.values(), mEnabled);
  }

  public ButtonView(UIObject_ inUiObject, Fields inFields, boolean inChild, Page.Name inPage)
  {
    this();
    mUIObject.setUpSection(inChild, inPage);
    set((Button_) inUiObject);
  }

  @Override
  public void setCallback(Callback<Boolean> inCallback)
  {
    mAction0.setCallback(inCallback);
    mAction1.setCallback(inCallback);
  }

  public void set(Button_ inUiObject)
  {
    mUiObject = inUiObject;

    mName.setText(mUiObject.getClass().getSimpleName());
    setSelectedIndex(mType, mUiObject.getButtonType());
    setSelectedIndex(mSize, mUiObject.getButtonSize());
    setSelectedIndex(mDataToggle, mUiObject.getDataToggle());
    setSelectedIndex(mBadgePosition, mUiObject.getBadgePosition());
    setSelectedIndex(mCaret, YesNoNull.value(mUiObject.getToggleCaret()));
    setSelectedIndex(mActive, YesNoNull.value(mUiObject.getActive()));
    setSelectedIndex(mEnabled, YesNoNull.value(mUiObject.getEnabled()));

    mCommandName.setText(mUiObject.commandName());
    mText.setText(mUiObject.getText());
    mBadgeText.setText(mUiObject.getBadgeText());

    mUIObject.set(mUiObject);
  }

  @UiHandler(
      {
        "mType",
        "mSize",
        "mCaret",
        "mDataToggle",
        "mBadgePosition",
        "mActive",
        "mEnabled"
      })
  public void onChangeBind(ChangeEvent inEvent)
  {
    mUiObject.setButtonType(getEnumValueFromListBox(ButtonType.values(), mType));
    mUiObject.setButtonSize(getEnumValueFromListBox(ButtonSize.values(), mSize));
    mUiObject.setDataToggle(getEnumValueFromListBox(Toggle.values(), mDataToggle));
    mUiObject.setBadgePosition(getEnumValueFromListBox(BadgePosition.values(), mBadgePosition));
    mUiObject.setToggleCaret(getEnumValueFromListBox(YesNoNull.values(), mCaret).value());
    mUiObject.setActive(getEnumValueFromListBox(YesNoNull.values(), mActive).value());
    mUiObject.setEnabled(getEnumValueFromListBox(YesNoNull.values(), mEnabled).value());

    mUiObject.setCommandName(mCommandName.getText());
    mUiObject.setText(mText.getText());
    mUiObject.setBadgeText(mBadgeText.getText());
  }
}