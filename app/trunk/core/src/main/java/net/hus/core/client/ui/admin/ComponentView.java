package net.hus.core.client.ui.admin;

import java.util.List;

import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.html.Span;
import org.gwtbootstrap3.extras.select.client.ui.Option;
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
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.Page.Section.Name;

public class ComponentView extends AbstractView implements ComponentDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ComponentView>
  {
  }

  @UiField
  Select mPages;

  @UiField
  Icon mAdd0, mSave0, mSave1;

  @UiField
  Input mAddPage, mDisplay;

  @UiField
  Span mName;

  @UiField
  ListBox mFvt, mFgg, mPageName;

  private Action mAction;

  public ComponentView()
  {
    initWidget(BINDER.createAndBindUi(this));

    addEnumToListBox(Page.Name.values(), mPageName);
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
        "mPages"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    if (mPages.equals(inEvent.getSource()))
    {
      mAction.select(mPages.getSelectedItem().getValue());
    }
  }

  @Override
  public void addPages(List<Lookup> inPages)
  {
    mPages.clear();
    for (Lookup value : inPages)
    {
      Option field = new Option();
      field.setText(value.getDisplay());
      field.setValue(value.getName());
      field.setId(value.getId().toString());
      mPages.add(field);
    }
    mPages.refresh();
    mPages.setValue(null);
  }

  @Override
  public void addPage(Components inPage)
  {
    mName.setText(inPage.getName());
    mDisplay.setText(inPage.getDisplay());

    mFvt.setSelectedIndex(getSelectedIndex(mFvt, inPage.getFieldTKG().getFvt()));
    mFgg.setSelectedIndex(getSelectedIndex(mFgg, inPage.getFieldTKG().getFgg()));
    setEnumValueToListBox(inPage.getFieldTKG().getPage(), mPageName);
    notify("Page: " + inPage.getFieldTKG().getFvt() + " " + inPage.getFieldTKG().getFgg());
  }

  @Override
  public void addFieldGroups(List<Lookup> inFieldGroups)
  {
    mFgg.clear();
    for (Lookup value : inFieldGroups)
    {
      mFgg.addItem(value.getDisplay(), value.getName());
    }
  }

  @Override
  public void addTables(List<Lookup> inTables)
  {
    mFvt.clear();
    for (Lookup value : inTables)
    {
      mFvt.addItem(value.getDisplay(), value.getName());
    }
  }
}