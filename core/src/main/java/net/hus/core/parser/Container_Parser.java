package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.Container_;

public class Container_Parser extends ComplexWidget_Parser
{
  public Container_Parser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Container", Container_.class);
    inXs.aliasAttribute(Container_.class, "mFluid", "fluid");
  }
}