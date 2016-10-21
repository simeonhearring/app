package net.hus.core.parser;

import net.hus.core.client.ui.Alert_;

public class AlertParser extends UIObjectParser<Alert_>
{
  public AlertParser()
  {
    super();

    alias("Alert", Alert_.class);
    aliasField("Text", Alert_.class, "mText");
    aliasAttribute(Alert_.class, "mType", "type");
    aliasAttribute(Alert_.class, "mDismissable", "dismissable");
    aliasAttribute(Alert_.class, "mFade", "fade");
  }
}