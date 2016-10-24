package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.Container_;

public class Container_Parser extends ComplexWidget_Parser<Container_>
{
  public Container_Parser()
  {
    xs((Parser<Container_>) this);
  }

  @Override
  public void xs(Parser<Container_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Container", Container_.class);
    inXs.aliasAttribute(Container_.class, "mFluid", "fluid");
  }
}