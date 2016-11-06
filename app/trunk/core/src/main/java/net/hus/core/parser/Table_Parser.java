package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.FlexTable_.Table;

public class Table_Parser extends UIObject_Parser<Table>
{
  public Table_Parser()
  {
    xs((Parser<Table>) this);
  }

  @Override
  public void xs(Parser<Table> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Table", Table.class);

    inXs.addImplicitCollection(Table.class, "mTable", String[].class);
  }
}