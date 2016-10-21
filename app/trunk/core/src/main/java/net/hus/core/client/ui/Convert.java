package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.Alert;
import org.gwtbootstrap3.client.ui.Badge;

import com.google.gwt.user.client.ui.UIObject;

public class Convert
{
  public Badge convert(Badge_ inBadge)
  {
    Badge ret = new Badge();

    create(ret, inBadge);

    ret.setText(inBadge.getText());

    return ret;
  }

  public Alert convert(Alert_ inAlert)
  {
    Alert ret = new Alert();

    create(ret, inAlert);

    ret.setText(inAlert.getText());
    ret.setType(inAlert.getType());
    ret.setDismissable(inAlert.isDismissable());
    ret.setFade(inAlert.isFade());

    return ret;
  }

  private void create(UIObject inUIObject, UIObject_ inUIObject_)
  {
    String height = inUIObject_.getHeight();
    if (height != null)
    {
      inUIObject.setHeight(height);
    }
    String width = inUIObject_.getWidth();
    if (width != null)
    {
      inUIObject.setWidth(width);
    }
    String title = inUIObject_.getTitle();
    if (title != null)
    {
      inUIObject.setTitle(title);
    }
    String stylePrimaryName = inUIObject_.getStylePrimaryName();
    if (stylePrimaryName != null)
    {
      inUIObject.setStylePrimaryName(stylePrimaryName);
    }
    String styleName = inUIObject_.getStyleName();
    if (styleName != null)
    {
      inUIObject.setStyleName(styleName);
    }
  }
}