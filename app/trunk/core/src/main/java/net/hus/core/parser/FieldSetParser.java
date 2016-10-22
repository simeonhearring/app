package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.FieldSet_;

public class FieldSetParser extends ComplexWidgetParser
{
  public FieldSetParser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("FieldSet", FieldSet_.class);
    inXs.aliasAttribute(FieldSet_.class, "mEnabled", "enabled");
  }
}