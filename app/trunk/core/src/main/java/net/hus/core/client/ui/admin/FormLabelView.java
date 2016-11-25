package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.html.Paragraph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.UIObjectDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.components.FormLabel_;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Page.Name;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.model.YesNoNull;

public class FormLabelView extends AbstractView implements UIObjectDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, FormLabelView>
  {
  }

  @UiField
  Paragraph mName;

  @UiField
  ListBox mShowRequiredIndicator;

  @UiField
  AbstractTextWidgetView mAbstractTextWidget;

  @UiField
  UIObjectView mUIObject;

  @UiField
  ActionView mAction0, mAction1;

  private FormLabel_ mUiObject;

  public FormLabelView()
  {
    initWidget(BINDER.createAndBindUi(this));
    addEnumDToListBox(YesNoNull.values(), mShowRequiredIndicator);
  }

  public FormLabelView(UIObject_ inUiObject, Fields inFields, boolean inParent, Name inPage)
  {
    this();
    mUIObject.setParent(inParent, inPage);
    mUIObject.setFields(Field.Component.FL00_, inFields);
    set((FormLabel_) inUiObject);
  }

  public void set(FormLabel_ inUiObject)
  {
    mUiObject = inUiObject;

    mName.setText(mUiObject.getClass().getSimpleName());
    setEnumValueToListBox(YesNoNull.value(mUiObject.getShowRequiredIndicator()),
        mShowRequiredIndicator);

    mAbstractTextWidget.set(mUiObject);
    mUIObject.set(mUiObject);
  }

  @UiHandler(
      {
        "mShowRequiredIndicator"
      })
  public void onChangeBind(ChangeEvent inEvent)
  {
    mUiObject.setShowRequiredIndicator(
        getEnumValueFromListBox(YesNoNull.values(), mShowRequiredIndicator).value());
  }
}