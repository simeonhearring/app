package net.hus.core.client.model.main;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.model.Page;

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