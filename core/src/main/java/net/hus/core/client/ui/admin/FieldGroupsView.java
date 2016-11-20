package net.hus.core.client.ui.admin;

import java.util.List;

import org.gwtbootstrap3.client.ui.CheckBox;
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
  Icon mAdd0, mSave1;

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
      mAction.select(selectedItem.getValue(), selectedItem.getText(), toLong(selectedItem.getId()));
    }
  }

  @UiHandler(
      {
        "mAdd0",
        "mSave1"
      })
  public void onClickBind(ClickEvent inEvent)
  {
    if (mAdd0.equals(inEvent.getSource()))
    {
      mAction.addGroup(mAddGroup.getText());
    }
    else if (mSave1.equals(inEvent.getSource()))
    {
      notify("Save");
      // TODO save mAction.save(getFields());
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
  }

  @Override
  public void addFields(List<Lookup> inFields)
  {
    for (Lookup value : inFields)
    {
      CheckBox box = new CheckBox();
      box.setText(value.getDisplay() + " (" + value.getAbbreviation().toLowerCase() + ")");
      box.setFormValue(value.getAltId() + "");
      mFields.add(box);
    }
  }

  @Override
  public void addFieldGroup(Fields inFieldGroup)
  {
    for (int i = 0; i < mFields.getWidgetCount(); i++)
    {
      CheckBox box = (CheckBox) mFields.getWidget(i);
      Long id = toLong(box.getFormValue());
      box.setValue(inFieldGroup.contains(id));
    }
  }

  @Override
  public void setGroupName(String inFgg, String inName)
  {
    mFgg.setText(inFgg);
    mName.setText(inName);
  }
}