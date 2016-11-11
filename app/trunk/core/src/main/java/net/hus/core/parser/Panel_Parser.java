package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.Panel_;

public class Panel_Parser extends ComplexWidget_Parser<Panel_>
{
  public Panel_Parser()
  {
    xs((Parser<Panel_>) this);
  }

  @Override
  public void xs(Parser<Panel_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Panel", Panel_.class);
    inXs.aliasAttribute(Panel_.class, "mType", "type");

    PanelHeader_Parser.xs(inXs);
    PanelBody_Parser.xs(inXs);
    PanelFooter_Parser.xs(inXs);
  }
}