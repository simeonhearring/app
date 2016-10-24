package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.Row_;

public class Row_Parser extends ComplexWidget_Parser<Row_>
{
  public Row_Parser()
  {
    xs((Parser<Row_>) this);
  }

  @Override
  public void xs(Parser<Row_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Row", Row_.class);
  }
}