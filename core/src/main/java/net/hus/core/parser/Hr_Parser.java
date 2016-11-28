package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.Hr_;

public class Hr_Parser extends ComplexWidget_Parser<Hr_>
{
  public Hr_Parser()
  {
    xs((Parser<Hr_>) this);
  }

  @Override
  public void xs(Parser<Hr_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Hr", Hr_.class);
  }
}