package net.hus.core.client.ui.admin;

import java.util.List;

import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.html.Paragraph;
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

  @UiField
  Icon mAdd0, mSave0;

  @UiField
  Input mFirst, mMiddle, mLast, mPassword;

  @UiField
  Input mAddUserName, mAddFirst, mAddLast;

  @UiField
  Paragraph mId, mCreated, mUpdated, mName, mUserName;

  @UiField
  ListBox mAddPage, mPage;

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
        "mSave0"
      })
  public void onClickBind(ClickEvent inEvent)
  {
    if (mAdd0.equals(inEvent.getSource()))
    {
      mAction.createProfile(mAddUserName.getText(), mAddFirst.getText(), mAddLast.getText(),
          mAddPage.getSelectedValue());
    }
    else if (mSave0.equals(inEvent.getSource()))
    {
      mAction.saveProfile(mFirst.getText(), mMiddle.getText(), mLast.getText(), mPassword.getText(),
          mPage.getSelectedValue());
    }
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
    mId.setText(inProfile.getId().toString());
    mCreated.setText(format("yyyy-MM-dd hh:mm", inProfile.getCreated()));
    mUpdated.setText(format("yyyy-MM-dd hh:mm", inProfile.getUpdated()));

    mName.setText(inProfile.getName());
    mUserName.setText(inProfile.getUserName());

    mFirst.setText(inProfile.getFirst());
    mMiddle.setText(inProfile.getMiddle());
    mLast.setText(inProfile.getLast());

    mPassword.setText(inProfile.getPassword());
    setSelectedIndex(mPage, inProfile.getPage().getComponentsName());

    mProfiles.setValue(null);
  }

  @Override
  public void reset()
  {
    mId.setText(null);
    mCreated.setText(null);
    mUpdated.setText(null);

    mName.setText(null);
    mUserName.setText(null);

    mFirst.setText(null);
    mMiddle.setText(null);
    mLast.setText(null);

    mPassword.setText(null);
    setSelectedIndex(mPage, null);

    mAddUserName.setText(null);
    mAddFirst.setText(null);
    mAddLast.setText(null);

    setSelectedIndex(mAddPage, null);

    mProfiles.setValue(null);
  }

  @Override
  public void addProfiles(List<Lookup> inProfiles)
  {
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

  @Override
  public void addPages(List<Lookup> inPages)
  {
    mPage.clear();
    mAddPage.clear();
    for (Lookup value : inPages)
    {
      mPage.addItem(value.getDisplay(), value.getName());
      mAddPage.addItem(value.getDisplay(), value.getName());
    }
  }
}