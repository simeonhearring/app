package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.PanelHeader_;

public class PanelHeader_Parser extends ComplexWidget_Parser<PanelHeader_>
{
  public PanelHeader_Parser()
  {
    xs((Parser<PanelHeader_>) this);
  }

  @Override
  public void xs(Parser<PanelHeader_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("PanelHeader", PanelHeader_.class);
  }
}