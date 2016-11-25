package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.extras.toggleswitch.client.ui.ToggleSwitch;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.UIObjectDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.components.AbstractTextWidget_;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.util.NumberUtil;
import net.hus.core.shared.util.StringUtil;

public class AbstractTextWidgetView extends AbstractView implements UIObjectDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, AbstractTextWidgetView>
  {
  }

  @UiField
  Input mText, mColor, mMarginBottom, mMarginLeft, mMarginRight, mMarginTop, mPaddingBottom,
  mPaddingLeft, mPaddingRight, mPaddingTop;

  @UiField
  ListBox mPull;

  @UiField
  ToggleSwitch mHtml;

  private AbstractTextWidget_ mUiObject;

  public AbstractTextWidgetView()
  {
    initWidget(BINDER.createAndBindUi(this));
    addEnumToListBox(Pull.values(), mPull, true);
  }

  public AbstractTextWidgetView(UIObject_ inUiObject)
  {
    this();
    set((AbstractTextWidget_) inUiObject);
  }

  public void set(AbstractTextWidget_ inUiObject)
  {
    mUiObject = inUiObject;

    mText.setText(mUiObject.getText());
    mColor.setText(mUiObject.getColor());
    mMarginBottom.setText(StringUtil.toString(mUiObject.getMarginBottom()));
    mMarginLeft.setText(StringUtil.toString(mUiObject.getMarginLeft()));
    mMarginRight.setText(StringUtil.toString(mUiObject.getMarginRight()));
    mMarginTop.setText(StringUtil.toString(mUiObject.getMarginTop()));
    mPaddingBottom.setText(StringUtil.toString(mUiObject.getPaddingBottom()));
    mPaddingLeft.setText(StringUtil.toString(mUiObject.getPaddingLeft()));
    mPaddingRight.setText(StringUtil.toString(mUiObject.getPaddingRight()));
    mPaddingTop.setText(StringUtil.toString(mUiObject.getPaddingTop()));

    mHtml.setValue(mUiObject.isHtml());

    setEnumValueToListBox(mPull, mUiObject.getPull());
  }

  @UiHandler(
      {
        "mPull"
      })
  public void onChangeBind(ChangeEvent inEvent)
  {
    mUiObject.setPull(getEnumValueFromListBox(Pull.values(), mPull));
  }

  @UiHandler(
      {
        "mHtml"
      })
  public void onValueChangeBooleanBind(ValueChangeEvent<Boolean> inEvent)
  {
    mUiObject.setHtml(mHtml.getValue());
  }

  @UiHandler(
      {
        "mText",
        "mColor",
        "mMarginBottom",
        "mMarginLeft",
        "mMarginRight",
        "mMarginTop",
        "mPaddingBottom",
        "mPaddingLeft",
        "mPaddingRight",
        "mPaddingTop",
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    mUiObject.setText(mText.getText());
    mUiObject.setColor(mColor.getText());
    mUiObject.setMarginBottom(NumberUtil.toDouble(mMarginBottom.getText()));
    mUiObject.setMarginLeft(NumberUtil.toDouble(mMarginLeft.getText()));
    mUiObject.setMarginRight(NumberUtil.toDouble(mMarginRight.getText()));
    mUiObject.setMarginTop(NumberUtil.toDouble(mMarginTop.getText()));
    mUiObject.setPaddingBottom(NumberUtil.toDouble(mPaddingBottom.getText()));
    mUiObject.setPaddingLeft(NumberUtil.toDouble(mPaddingLeft.getText()));
    mUiObject.setPaddingRight(NumberUtil.toDouble(mPaddingRight.getText()));
    mUiObject.setPaddingTop(NumberUtil.toDouble(mPaddingTop.getText()));
  }
}