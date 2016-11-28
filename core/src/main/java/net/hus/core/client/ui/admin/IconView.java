package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.constants.Emphasis;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
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
import net.hus.core.shared.components.Icon_;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.model.YesNoNull;

public class IconView extends AbstractView implements UIObjectDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, IconView>
  {
  }

  @UiField
  Paragraph mName;

  @UiField
  ListBox mType, mSize, mRotate, mFlip, mEmphasis, mBorder, mSpin, mPulse, mInverse, mStackTop,
  mStackBase, mFixedWidth;

  @UiField
  UIObjectView mUIObject;

  @UiField
  ActionView mAction0, mAction1;

  private Icon_ mUiObject;

  public IconView()
  {
    initWidget(BINDER.createAndBindUi(this));

    addEnumToListBox(IconType.values(), mType);
    addEnumToListBox(IconSize.values(), mSize);
    addEnumToListBox(IconRotate.values(), mRotate, true);
    addEnumToListBox(IconFlip.values(), mFlip, true);
    addEnumToListBox(Emphasis.values(), mEmphasis, true);
    addEnumToListBox(YesNoNull.values(), mBorder);
    addEnumToListBox(YesNoNull.values(), mSpin);
    addEnumToListBox(YesNoNull.values(), mPulse);
    addEnumToListBox(YesNoNull.values(), mInverse);
    addEnumToListBox(YesNoNull.values(), mStackTop);
    addEnumToListBox(YesNoNull.values(), mStackBase);
    addEnumToListBox(YesNoNull.values(), mFixedWidth);

    // TODO complex widget
  }

  public IconView(UIObject_ inUiObject, boolean inChild, Page.Layout inPage)
  {
    this();
    mUIObject.setUpSection(inChild, inPage);
    set((Icon_) inUiObject);
  }

  @Override
  public void setCallback(Callback<IconType> inCallback)
  {
    mAction0.setCallback(inCallback);
    mAction1.setCallback(inCallback);
  }

  public void set(Icon_ inUiObject)
  {
    mUiObject = inUiObject;
    mName.setText(mUiObject.getSimpleName());

    setSelectedIndex(mType, mUiObject.getType());
    setSelectedIndex(mSize, mUiObject.getSize());
    setSelectedIndex(mRotate, mUiObject.getRotate());
    setSelectedIndex(mFlip, mUiObject.getFlip());
    setSelectedIndex(mEmphasis, mUiObject.getEmphasis());
    setSelectedIndex(mBorder, YesNoNull.value(mUiObject.getBorder()));
    setSelectedIndex(mSpin, YesNoNull.value(mUiObject.getSpin()));
    setSelectedIndex(mPulse, YesNoNull.value(mUiObject.getPulse()));
    setSelectedIndex(mInverse, YesNoNull.value(mUiObject.getInverse()));
    setSelectedIndex(mStackTop, YesNoNull.value(mUiObject.getStackTop()));
    setSelectedIndex(mStackBase, YesNoNull.value(mUiObject.getStackBase()));
    setSelectedIndex(mFixedWidth, YesNoNull.value(mUiObject.getFixedWidth()));

    mUIObject.set(mUiObject);
  }

  @UiHandler(
      {
        "mType",
        "mSize",
        "mRotate",
        "mFlip",
        "mEmphasis",
        "mBorder",
        "mSpin",
        "mPulse",
        "mInverse",
        "mStackTop",
        "mStackBase",
        "mFixedWidth"
      })
  public void onChangeBind(ChangeEvent inEvent)
  {
    mUiObject.setType(getEnumValueFromListBox(IconType.values(), mType));
    mUiObject.setSize(getEnumValueFromListBox(IconSize.values(), mSize));
    mUiObject.setRotate(getEnumValueFromListBox(IconRotate.values(), mRotate));
    mUiObject.setFlip(getEnumValueFromListBox(IconFlip.values(), mFlip));
    mUiObject.setEmphasis(getEnumValueFromListBox(Emphasis.values(), mEmphasis));
    mUiObject.setBorder(getEnumValueFromListBox(YesNoNull.values(), mBorder).value());
    mUiObject.setSpin(getEnumValueFromListBox(YesNoNull.values(), mSpin).value());
    mUiObject.setPulse(getEnumValueFromListBox(YesNoNull.values(), mPulse).value());
    mUiObject.setInverse(getEnumValueFromListBox(YesNoNull.values(), mInverse).value());
    mUiObject.setStackTop(getEnumValueFromListBox(YesNoNull.values(), mStackTop).value());
    mUiObject.setStackBase(getEnumValueFromListBox(YesNoNull.values(), mStackBase).value());
    mUiObject.setFixedWidth(getEnumValueFromListBox(YesNoNull.values(), mFixedWidth).value());
  }
}