package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.CheckBox_;

public class CheckBox_Parser extends ButtonBase_Parser<CheckBox_>
{
  public CheckBox_Parser()
  {
    xs((Parser<CheckBox_>) this);
  }

  @Override
  public void xs(Parser<CheckBox_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("CheckBox", CheckBox_.class);
    inXs.aliasField("Text", CheckBox_.class, "mText");
    inXs.aliasAttribute(CheckBox_.class, "mHtml", "isHtml");
    inXs.aliasAttribute(CheckBox_.class, "mValue", "value");
  }
}