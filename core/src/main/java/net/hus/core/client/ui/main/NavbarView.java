package net.hus.core.client.ui.main;

import org.gwtbootstrap3.client.ui.AnchorListItem;

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
  AnchorListItem mHome, mAbout, mLoginout, mRegister;

  private boolean mLogin = true;

  public NavbarView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @UiHandler(
  {
      "mHome",
      "mLoginout",
      "mRegister"
  })
  public void onClickBind(ClickEvent inEvent)
  {
    if (mHome.getWidget(0).equals(inEvent.getSource()))
    {
      mLogin = false;
      logInOut();
    }
    else if (mLoginout.getWidget(0).equals(inEvent.getSource()))
    {
      logInOut();
    }
    else if (mRegister.getWidget(0).equals(inEvent.getSource()))
    {
      Global.fire(new ProfileEvent(Profile.Code.nADMIN));
    }
  }

  private void logInOut()
  {
    mLoginout.setText(mLogin ? "Logout" : "Login");
    if (mLogin)
    {
      Global.fire(new ProfileEvent(Profile.Code.nLOGIN));
    }
    else
    {
      Global.fire(new ProfileEvent(Profile.Code.nHOME));
    }
    mLogin = !mLogin;
  }

  @Override
  public void clearActive()
  {
    mHome.setActive(false);
    mAbout.setActive(false);
    mLoginout.setActive(false);
    mRegister.setActive(false);
  }
}