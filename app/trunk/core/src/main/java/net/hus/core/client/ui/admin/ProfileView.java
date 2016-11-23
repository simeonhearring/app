package net.hus.core.client.ui.admin;

import java.util.List;

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

import net.hus.core.client.model.admin.ProfileDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Page.Section.Name;
import net.hus.core.shared.model.Profile;

public class ProfileView extends AbstractView implements ProfileDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, ProfileView>
  {
  }

  @UiField
  Select mProfiles;

  // @UiField
  // Icon mAdd0, mSave0, mSave1;

  // @UiField
  // Input mAddLookups, mDisplay, mNewName, mNewAbbr, mNewSort;

  // @UiField
  // Span mName;
  //
  // @UiField
  // FormLabel mNameText;

  private Action mAction;

  public ProfileView()
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
        "mAdd0",
        "mSave0",
        "mSave1",
      })
  public void onClickBind(ClickEvent inEvent)
  {
    // if (mAdd0.equals(inEvent.getSource()))
    // {
    // }
    // else if (mSave0.equals(inEvent.getSource()))
    // {
    // }
    // else if (mSave1.equals(inEvent.getSource()))
    // {
    // }
  }

  @UiHandler(
      {
        "mProfiles"
      })
  public void onValueChangeBind(ValueChangeEvent<String> inEvent)
  {
    if (mProfiles.equals(inEvent.getSource()))
    {
      mAction.select(mProfiles.getSelectedItem().getValue());
    }
  }

  @Override
  public void addProfile(Profile inProfile)
  {
    notify("Got profile");
  }

  @Override
  public void addProfiles(List<Lookup> inProfiles)
  {
    notify("size: " + inProfiles.size());
    mProfiles.clear();
    for (Lookup value : inProfiles)
    {
      Option field = new Option();
      field.setText(value.getDisplay());
      field.setValue(value.getName());
      field.setId(value.getId().toString());
      mProfiles.add(field);
    }
    mProfiles.refresh();
    mProfiles.setValue(null);
  }
}