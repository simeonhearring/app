package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.constants.Alignment;
import org.gwtbootstrap3.client.ui.constants.Emphasis;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
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
import net.hus.core.shared.components.Heading_;
import net.hus.core.shared.model.Page.Layout;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.util.StringUtil;

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

  @Override
  public void setCallback(Callback<IconType> inCallback)
  {
    mAction0.setCallback(inCallback);
    mAction1.setCallback(inCallback);
  }

  public HeadingView(UIObject_ inUiObject, boolean inChild, Layout inPage)
  {
    this();
    mUIObject.setUpSection(inChild, inPage);
    set((Heading_) inUiObject);
  }

  public void set(Heading_ inUiObject)
  {
    mUiObject = inUiObject;
    mName.setText(mUiObject.getSimpleName());

    setSelectedIndex(mSize, mUiObject.getSize());
    setSelectedIndex(mEmphasis, mUiObject.getEmphasis());
    setSelectedIndex(mAlignment, mUiObject.getAlignment());

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
    mUiObject.setText(StringUtil.nullIfEmpty(mText.getText()));
    mUiObject.setSubText(StringUtil.nullIfEmpty(mSubText.getText()));
  }
}