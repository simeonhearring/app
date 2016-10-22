package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.CheckBox_;

public class CheckBox_Parser extends FocusWidget_Parser<CheckBox_>
{
  public CheckBox_Parser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("CheckBox", CheckBox_.class);
    inXs.aliasField("Text", CheckBox_.class, "mText");
    inXs.aliasAttribute(CheckBox_.class, "mHtml", "isHtml");
    inXs.aliasAttribute(CheckBox_.class, "mValue", "value");
  }
}