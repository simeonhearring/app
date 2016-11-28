package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.Br_;

public class Br_Parser extends ComplexWidget_Parser<Br_>
{
  public Br_Parser()
  {
    xs((Parser<Br_>) this);
  }

  @Override
  public void xs(Parser<Br_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Br", Br_.class);
  }
}