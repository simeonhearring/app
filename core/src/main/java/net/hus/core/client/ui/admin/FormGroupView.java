package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.constants.FormGroupSize;
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
import net.hus.core.shared.components.FormGroup_;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.UIObject_;

public class FormGroupView extends AbstractView implements UIObjectDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, FormGroupView>
  {
  }

  @UiField
  Paragraph mName;

  @UiField
  ListBox mSize;

  @UiField
  UIObjectView mUIObject;

  @UiField
  ActionView mAction0, mAction1;

  private FormGroup_ mUiObject;

  public FormGroupView()
  {
    initWidget(BINDER.createAndBindUi(this));
    addEnumToListBox(FormGroupSize.values(), mSize);
  }

  public FormGroupView(UIObject_ inUiObject, boolean inChild, Page.Name inPage)
  {
    this();
    mUIObject.setUpSection(inChild, inPage);
    set((FormGroup_) inUiObject);
  }

  @Override
  public void setCallback(Callback<Boolean> inCallback)
  {
    mAction0.setCallback(inCallback);
    mAction1.setCallback(inCallback);
  }

  public void set(FormGroup_ inUiObject)
  {
    mUiObject = inUiObject;

    mName.setText(mUiObject.getClass().getSimpleName());
    setSelectedIndex(mSize, mUiObject.getSize());

    mUIObject.set(mUiObject);
  }

  @UiHandler(
      {
        "mSize"
      })
  public void onChangeBind(ChangeEvent inEvent)
  {
    mUiObject.setSize(getEnumValueFromListBox(FormGroupSize.values(), mSize));
  }
}