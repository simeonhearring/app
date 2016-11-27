package net.hus.core.client.ui.main;

import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.NavbarBrand;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.main.NavbarDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.client.ui.common.Global;
import net.hus.core.client.ui.event.ProfileEvent;
import net.hus.core.shared.model.Profile;

public class NavbarView extends AbstractView implements NavbarDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, NavbarView>
  {
  }

  @UiField
  AnchorListItem mHome, mAbout, mLogin, mLogout, mRegister;

  @UiField
  NavbarBrand mCompany;

  public NavbarView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @UiHandler(
      {
        "mHome",
        "mLogin",
        "mLogout"
      })
  public void onClickBind(ClickEvent inEvent)
  {
    if (mHome.getWidget(0).equals(inEvent.getSource()))
    {
      Global.fire(new ProfileEvent(Profile.UserName.home));
    }
    else if (mLogout.getWidget(0).equals(inEvent.getSource()))
    {
      notify("Logging out... (bye)");
      Global.fire(new ProfileEvent(Profile.UserName.home));
    }
    else if (mLogin.getWidget(0).equals(inEvent.getSource()))
    {
      Global.fire(new ProfileEvent(Profile.UserName.login));
    }
  }

  @Override
  public void clearActive()
  {
    mHome.setActive(false);
    mAbout.setActive(false);
    mLogin.setActive(false);
    mLogout.setActive(false);
    mRegister.setActive(false);
  }
}