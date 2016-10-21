package net.hus.core.parser;

import net.hus.core.client.ui.Input_;

public class InputParser extends ValueBoxBaseParser<String>
{
  public InputParser()
  {
    super();

    alias("Input", Input_.class);
    aliasField("Value", Input_.class, "mValue");
    aliasAttribute(Input_.class, "mType", "type");
    aliasAttribute(Input_.class, "mMin", "min");
    aliasAttribute(Input_.class, "mMax", "max");
  }
}