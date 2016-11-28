package net.hus.core.client.model.main;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.model.admin.AdminPresenter;
import net.hus.core.client.model.select.SelectFVKPresenter;
import net.hus.core.shared.model.FieldTKG;

public class PageLocater
{
  public static PageDisplay page(MainDisplay inDisplay, FieldTKG inTKG)
  {
    PageDisplay ret = null;

    switch (inTKG.getLayout())
    {
      case HOME:
        ret = inDisplay.geHome();
        break;
      case LOGIN:
        ret = inDisplay.getLogin();
        break;
      case ADMIN:
        ret = new AdminPresenter(inDisplay.getAdmin()).getDisplay();
        break;
      case WEB:
        ret = new SelectFVKPresenter(inTKG, inDisplay.getWeb()).getDisplay();
        break;
      // case BLOG:
      // ret = inDisplay.getBlog();
      // break;
      // case MARKET:
      // ret = inDisplay.getMarketing();
      // break;
      default:
        ret = inDisplay.geHome();
        break;
    }
    return ret;
  }
}