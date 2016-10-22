package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.Alert_;

public class AlertParser extends UIObjectParser<Alert_>
{
  public AlertParser()
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