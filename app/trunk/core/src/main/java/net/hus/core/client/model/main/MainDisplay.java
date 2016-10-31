package net.hus.core.client.model.main;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.Display;
import net.hus.core.client.common.UiCreate;
import net.hus.core.client.model.page.BlogDisplay;
import net.hus.core.client.model.page.LoginDisplay;
import net.hus.core.client.model.page.MarketingDisplay;
import net.hus.core.client.model.page.WebPageDisplay;

public interface MainDisplay extends Display
{
  void add(Display inDisplay);

  void add(IsWidget inWidget);

  void clear();

  LoginDisplay getLogin();

  BlogDisplay getBlog();

  WebPageDisplay getWebPage();

  MarketingDisplay getMarketing();

  UiCreate getUiCreate();
}