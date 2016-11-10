package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.ComplexPanel_;

public class ComplexPanel_Parser<T> extends UIObject_Parser<T>
{
  public ComplexPanel_Parser()
  {
    xs((Parser<T>) this);
  }

  @Override
  public void xs(Parser<T> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("ComplexPanel", ComplexPanel_.class);
    inXs.aliasField("Collection", ComplexPanel_.class, "mCollection");
  }
}