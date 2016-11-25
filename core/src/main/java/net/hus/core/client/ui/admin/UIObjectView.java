package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.UIObjectDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.Page.Section;
import net.hus.core.shared.model.UIObject_;

public class UIObjectView extends AbstractView implements UIObjectDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, UIObjectView>
  {
  }

  @UiField
  Input mHeight, mWidth, mTitle, mStyleName, mStylePrimaryName;

  @UiField
  ListBox mKey, mSection;

  private UIObject_ mUiObject;

  public UIObjectView()
  {
    initWidget(BINDER.createAndBindUi(this));
    addEnumToListBox(Section.Name.values(), mSection, true);
  }

  public UIObjectView(UIObject_ inUiObject)
  {
    this();
    set(inUiObject);
  }

  public void set(UIObject_ inUiObject)
  {
    mUiObject = inUiObject;

    mHeight.setText(mUiObject.getHeight());
    mWidth.setText(mUiObject.getWidth());
    mTitle.setText(mUiObject.getTitle());
    mStyleName.setText(mUiObject.getStyleName());
    mStylePrimaryName.setText(mUiObject.getStylePrimaryName());

    setEnumValueToListBox(mSection, mUiObject.getSection());
    setSelectedIndex(mKey, mUiObject.getKey());
  }

  @UiHandler(
      {
        "mKey",
        "mSection"
      })
  public void onChangeBind(ChangeEvent inEvent)
  {
    mUiObject.setKey(mKey.getSelectedValue());
    mUiObject.setSection(getEnumValueFromListBox(Section.Name.values(), mSection));
  }

  @UiHandler(
      {
        "mHeight",
        "mWidth",
        "mTitle",
        "mStyleName",
        "mStylePrimaryName"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    mUiObject.setHeight(mHeight.getText());
    mUiObject.setWidth(mWidth.getText());
    mUiObject.setTitle(mTitle.getText());
    mUiObject.setStyleName(mStyleName.getText());
    mUiObject.setStylePrimaryName(mStylePrimaryName.getText());
  }

  public void setFields(Field.Component inComponent, Fields inFields)
  {
    mKey.setEnabled(true);
    mKey.addItem("Select One", "");
    for (Field value : inFields.getFields())
    {
      mKey.addItem(value.getDisplayLong(), inComponent.name() + value.getId());
    }
  }

  public void setUpSection(boolean inChild, Page.Name inPage)
  {
    addEnumToListBox(Section.Name.values(inPage), mSection, true);
    mSection.setEnabled(!inChild);
  }
}