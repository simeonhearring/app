package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.Input_;

public class InputParser extends ValueBoxBaseParser
{
  public InputParser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Input", Input_.class);
    inXs.aliasField("Value", Input_.class, "mValue");
    inXs.aliasAttribute(Input_.class, "mType", "type");
    inXs.aliasAttribute(Input_.class, "mMin", "min");
    inXs.aliasAttribute(Input_.class, "mMax", "max");
  }
}