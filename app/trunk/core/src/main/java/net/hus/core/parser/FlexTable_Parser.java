package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.FlexTable_;

public class FlexTable_Parser extends UIObject_Parser<FlexTable_>
{
  public FlexTable_Parser()
  {
    xs((Parser<FlexTable_>) this);
  }

  @Override
  public void xs(Parser<FlexTable_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("FlexTable", FlexTable_.class);
    inXs.aliasField("Table", FlexTable_.class, "mTable");

    Table_Parser.xs(inXs);
  }
}