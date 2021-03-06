package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.ButtonBase_;

public class ButtonBase_Parser<T> extends FocusWidget_Parser<T>
{
  public ButtonBase_Parser()
  {
    xs((Parser<T>) this);
  }

  @Override
  public void xs(Parser<T> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("ButtonBase", ButtonBase_.class);
    inXs.aliasField("Text", ButtonBase_.class, "mText");
    inXs.aliasAttribute(ButtonBase_.class, "mHtml", "isHtml");
  }
}