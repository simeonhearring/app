package net.hus.core.parser;

import net.hus.core.client.ui.FieldSet_;

public class FieldSetParser extends ComplexWidgetParser
{
  public FieldSetParser()
  {
    super();

    alias("FieldSet", FieldSet_.class);
    aliasAttribute(FieldSet_.class, "mEnabled", "enabled");
  }
}