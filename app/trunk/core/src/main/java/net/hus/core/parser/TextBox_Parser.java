package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.TextBox_;

public class TextBox_Parser extends ValueBoxBase_Parser
{
  public TextBox_Parser()
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