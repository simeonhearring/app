package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.TextBox_;

public class TextBoxParser extends ValueBoxBaseParser
{
  public TextBoxParser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("TextBox", TextBox_.class);
    inXs.aliasField("Value", TextBox_.class, "mValue");
    // inXs.aliasSystemAttribute(null, "class");
  }
}