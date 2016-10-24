package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.ButtonBase_;

public class ButtonBase_Parser<T> extends FocusWidget_Parser<T>
{
  public ButtonBase_Parser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("ButtonBase", ButtonBase_.class);
    inXs.aliasField("Text", ButtonBase_.class, "mText");
    inXs.aliasAttribute(ButtonBase_.class, "mHtml", "isHtml");
  }
}