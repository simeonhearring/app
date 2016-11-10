package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.PanelBody_;
import net.hus.core.shared.components.PanelFooter_;

public class PanelFooter_Parser extends UIObject_Parser<PanelFooter_>
{
  public PanelFooter_Parser()
  {
    xs((Parser<PanelFooter_>) this);
  }

  @Override
  public void xs(Parser<PanelFooter_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("PanelFooter", PanelBody_.class);
    inXs.aliasField("Collection", PanelBody_.class, "mCollection");
  }
}