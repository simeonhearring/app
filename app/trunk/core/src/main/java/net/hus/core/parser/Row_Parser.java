package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.Row_;

public class Row_Parser extends ComplexWidget_Parser
{
  public Row_Parser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Row", Row_.class);
  }
}