package net.hus.core.client.model.main;

import net.hus.core.client.common.Display;
import net.hus.core.client.model.common.AnchorListItemDisplay;

public interface NavbarDisplay extends Display
{
  AnchorListItemDisplay getProfile();

  AnchorListItemDisplay getLogin();

  AnchorListItemDisplay getRegister();

  AnchorListItemDisplay getLogout();

  AnchorListItemDisplay getAbout();

  AnchorListItemDisplay getHome();

  void clearActive();
}