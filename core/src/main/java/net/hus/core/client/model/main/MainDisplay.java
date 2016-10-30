package net.hus.core.client.model.main;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.Display;
import net.hus.core.client.model.template.BlogDisplay;
import net.hus.core.client.model.template.LoginDisplay;
import net.hus.core.client.model.template.MarketingDisplay;
import net.hus.core.client.model.template.WebPageDisplay;

public interface MainDisplay extends Display
{
  void add(Display inDisplay);

  void add(IsWidget inWidget);

  void clear();

  LoginDisplay getLogin();

  BlogDisplay getBlog();

  WebPageDisplay getWebPage();

  MarketingDisplay getMarketing();
}