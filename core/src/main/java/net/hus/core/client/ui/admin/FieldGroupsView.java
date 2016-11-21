package net.hus.core.client.ui.admin;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;
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

import net.hus.core.client.model.admin.FieldGroupsDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Page.Section.Name;

public class FieldGroupsView extends AbstractView implements FieldGroupsDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, FieldGroupsView>
  {
  }

  @UiField
  Select mGroups;

  @UiField
  Input mAddGroup, mName;

  @UiField
  FlowPanel mFields;

  @UiField
  Span mFgg;

  @UiField
  FormLabel mNameText;

  @UiField
  Icon mAdd0, mSave0, mSave1, mRefresh0, mRefresh1;

  private Action mAction;

  public FieldGroupsView()
  {
    initWidget(BINDER.createAndBindUi(this));
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
        "mGroups"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    if (mGroups.equals(inEvent.getSource()))
    {
      Option selectedItem = mGroups.getSelectedItem();
      mAction.select(selectedItem.getValue(), selectedItem.getText());
    }
  }

  @UiHandler(
      {
        "mAdd0",
        "mSave0",
        "mSave1",
        "mRefresh0",
        "mRefresh1"
      })
  public void onClickBind(ClickEvent inEvent)
  {
    Object source = inEvent.getSource();
    if (mAdd0.equals(source))
    {
      mAction.createGroup(mAddGroup.getText());
    }
    else if (mSave0.equals(source))
    {
      mAction.saveGroupName(mFgg.getText(), mName.getText());
    }
    else if (mSave1.equals(source))
    {
      mAction.saveFields(mFgg.getText(), mName.getText(), selectedFieldIds());
    }
    else if (mRefresh0.equals(source) || mRefresh1.equals(source))
    {
      mAction.refresh();
    }
  }

  @Override
  public void addGroups(List<Lookup> inFieldGroups)
  {
    mGroups.clear();
    for (Lookup value : inFieldGroups)
    {
      Option field = new Option();
      field.setText(value.getDisplay());
      field.setValue(value.getName());
      field.setId(value.getId().toString());
      mGroups.add(field);
    }
    mGroups.refresh();
    mGroups.setValue(null);
  }

  private List<Long> selectedFieldIds()
  {
    List<Long> ret = new ArrayList<>();
    for (int i = 0; i < mFields.getWidgetCount(); i++)
    {
      CheckBox box = (CheckBox) mFields.getWidget(i);
      if (box.getValue())
      {
        ret.add(toLong(box.getFormValue()));
      }
    }
    return ret;
  }

  @Override
  public void addFields(List<Lookup> inFields)
  {
    mFields.clear();
    for (Lookup value : inFields)
    {
      CheckBox box = new CheckBox();
      box.setText(value.getDisplay() + " (" + value.getAbbreviation().toLowerCase() + ")");
      box.setFormValue(value.getAltId() + "");
      mFields.add(box);
    }
  }

  @Override
  public void selectFields(Fields inFields)
  {
    for (int i = 0; i < mFields.getWidgetCount(); i++)
    {
      CheckBox box = (CheckBox) mFields.getWidget(i);
      Long id = toLong(box.getFormValue());
      box.setValue(inFields.contains(id));
    }
    mGroups.setValue(null);
  }

  @Override
  public void setGroupName(String inFgg, String inName)
  {
    mFgg.setText(inFgg);
    mName.setText(inName);
    mNameText.setText(inName);
  }

  @Override
  public void reset()
  {
    setGroupName(null, null);
  }
}