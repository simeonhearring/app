package net.hus.core.client.ui.main;

import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.NavbarBrand;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.common.AnchorListItemDisplay;
import net.hus.core.client.model.main.NavbarDisplay;
import net.hus.core.client.ui.common.AbstractView;
import net.hus.core.client.ui.common.AnchorListItemView;

public class NavbarView extends AbstractView implements NavbarDisplay
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, NavbarView>
  {
  }

  @UiField
  AnchorListItem mHome, mAbout, mProfile, mLogin, mLogout, mRegister;

  @UiField
  NavbarBrand mCompany;

  public NavbarView()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public void clearActive()
  {
    mHome.setActive(false);
    mAbout.setActive(false);
    mProfile.setActive(false);
    mLogin.setActive(false);
    mLogout.setActive(false);
    mRegister.setActive(false);
  }


  @Override
  public AnchorListItemDisplay getHome()
  {
    return new AnchorListItemView(mHome);
  }

  @Override
  public AnchorListItemDisplay getAbout()
  {
    return new AnchorListItemView(mAbout);
  }

  @Override
  public AnchorListItemDisplay getProfile()
  {
    return new AnchorListItemView(mProfile);
  }

  @Override
  public AnchorListItemDisplay getLogin()
  {
    return new AnchorListItemView(mLogin);
  }

  @Override
  public AnchorListItemDisplay getLogout()
  {
    return new AnchorListItemView(mLogout);
  }

  @Override
  public AnchorListItemDisplay getRegister()
  {
    return new AnchorListItemView(mRegister);
  }
}