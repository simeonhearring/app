package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.constants.Alignment;
import org.gwtbootstrap3.client.ui.constants.Emphasis;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.html.Paragraph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.UIObjectDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.components.Heading_;
import net.hus.core.shared.model.UIObject_;

public class HeadingView extends AbstractView implements UIObjectDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, HeadingView>
  {
  }

  @UiField
  Paragraph mName;

  @UiField
  ListBox mSize, mEmphasis, mAlignment;

  @UiField
  Input mText, mSubText;

  @UiField
  UIObjectView mUIObject;

  @UiField
  ActionView mAction0, mAction1;

  private Heading_ mUiObject;

  public HeadingView()
  {
    initWidget(BINDER.createAndBindUi(this));
    addEnumToListBox(HeadingSize.values(), mSize);
    addEnumToListBox(Emphasis.values(), mEmphasis);
    addEnumToListBox(Alignment.values(), mAlignment);
  }

  public HeadingView(UIObject_ inUiObject)
  {
    this();
    set(inUiObject);
  }

  public void set(UIObject_ inUiObject)
  {
    mUiObject = (Heading_) inUiObject;
    mName.setText(mUiObject.getClass().getSimpleName());
    setEnumValueToListBox(mUiObject.getSize(), mSize);
    setEnumValueToListBox(mUiObject.getEmphasis(), mEmphasis);
    setEnumValueToListBox(mUiObject.getAlignment(), mAlignment);
    mText.setText(mUiObject.getText());
    mSubText.setText(mUiObject.getSubText());
    mUIObject.set(mUiObject);
  }

  @UiHandler(
      {
        "mSize",
        "mEmphasis",
        "mAlignment"
      })
  public void onChangeBind(ChangeEvent inEvent)
  {
    mUiObject.setSize(getEnumValueFromListBox(HeadingSize.values(), mSize));
    mUiObject.setEmphasis(getEnumValueFromListBox(Emphasis.values(), mEmphasis));
    mUiObject.setAlignment(getEnumValueFromListBox(Alignment.values(), mAlignment));
  }

  @UiHandler(
      {
        "mText",
        "mSubText"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    mUiObject.setText(mText.getText());
    mUiObject.setSubText(mSubText.getText());
  }
}