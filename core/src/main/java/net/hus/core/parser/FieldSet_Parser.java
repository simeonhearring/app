package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.FieldSet_;

public class FieldSet_Parser extends ComplexWidget_Parser<FieldSet_>
{
  public FieldSet_Parser()
  {
    xs((Parser<FieldSet_>) this);
  }

  @Override
  public void xs(Parser<FieldSet_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("FieldSet", FieldSet_.class);
    inXs.aliasAttribute(FieldSet_.class, "mEnabled", "enabled");
  }
}