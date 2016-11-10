package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.PanelBody_;

public class PanelBody_Parser extends UIObject_Parser<PanelBody_>
{
  public PanelBody_Parser()
  {
    xs((Parser<PanelBody_>) this);
  }

  @Override
  public void xs(Parser<PanelBody_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("PanelBody", PanelBody_.class);
    inXs.aliasField("Collection", PanelBody_.class, "mCollection");
  }
}