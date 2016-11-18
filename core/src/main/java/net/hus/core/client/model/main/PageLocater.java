package net.hus.core.client.model.main;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.model.admin.FieldsPresenter;
import net.hus.core.shared.model.Page;

public class PageLocater
{
  public static PageDisplay page(MainDisplay inDisplay, Page.Name inPage)
  {
    PageDisplay ret = null;

    switch (inPage)
    {
      case BLOG:
        ret = inDisplay.getBlog();
        break;
      case WEB:
        ret = inDisplay.getWeb();
        break;
      case MARKET:
        ret = inDisplay.getMarketing();
        break;
      case ADMIN:
        ret = new FieldsPresenter(inDisplay.getAdmin()).getDisplay();
        break;
      case LOGIN:
        ret = inDisplay.getLogin();
        break;
      default:
        ret = inDisplay.getLogin();
        break;
    }
    return ret;
  }
}