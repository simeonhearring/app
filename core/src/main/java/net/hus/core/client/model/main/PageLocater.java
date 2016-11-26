package net.hus.core.client.model.main;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.client.model.admin.AdminPresenter;
import net.hus.core.client.model.page.WebDisplay;
import net.hus.core.client.model.select.SelectFVKPresenter;
import net.hus.core.shared.model.FieldTKG;

public class PageLocater
{
  public static PageDisplay page(MainDisplay inDisplay, FieldTKG inTKG)
  {
    PageDisplay ret = null;

    switch (inTKG.getPage())
    {
      case BLOG:
        ret = inDisplay.getBlog();
        break;
      case WEB:
      {
        ret = inDisplay.getWeb();
        new SelectFVKPresenter(inTKG, ((WebDisplay) ret).getSelect());
        break;
      }
      case MARKET:
        ret = inDisplay.getMarketing();
        break;
      case ADMIN:
        ret = new AdminPresenter(inDisplay.getAdmin()).getDisplay();
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