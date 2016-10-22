package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.Alert_;

public class Alert_Parser extends UIObject_Parser<Alert_>
{
  public Alert_Parser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Alert", Alert_.class);
    inXs.aliasField("Text", Alert_.class, "mText");
    inXs.aliasAttribute(Alert_.class, "mType", "type");
    inXs.aliasAttribute(Alert_.class, "mDismissable", "dismissable");
    inXs.aliasAttribute(Alert_.class, "mFade", "fade");
  }
}