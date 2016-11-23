package net.hus.core.client.ui.admin;

import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.html.Span;
import org.gwtbootstrap3.extras.select.client.ui.Select;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.admin.ComponentDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.client.ui.components.FlexTable_View;
import net.hus.core.shared.model.Page.Section.Name;

public class ComponentView extends AbstractView implements ComponentDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ComponentView>
  {
  }

  @UiField
  Select mLookups;

  @UiField
  FlexTable_View mValues;

  @UiField
  Icon mAdd0, mSave0, mSave1;

  @UiField
  Input mAddLookups, mDisplay, mNewName, mNewAbbr, mNewSort;

  @UiField
  Span mName;

  @UiField
  FormLabel mNameText;

  private Action mAction;

  public ComponentView()
  {
    initWidget(BINDER.createAndBindUi(this));
    mValues.showActions(false);
  }

  @Override
  public void setAction(Action inAction)
  {
    mAction = inAction;
  }

  @Override
  public void add(Name inSection, IsWidget inComponent)
  {
    // do nothing
  }

  @UiHandler(
      {
        "mAdd0",
        "mSave0",
        "mSave1",
      })
  public void onClickBind(ClickEvent inEvent)
  {
    if (mAdd0.equals(inEvent.getSource()))
    {
    }
    else if (mSave0.equals(inEvent.getSource()))
    {
    }
    else if (mSave1.equals(inEvent.getSource()))
    {
    }
  }

  @UiHandler(
      {
        "mLookups"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    if (mLookups.equals(inEvent.getSource()))
    {
    }
  }
}