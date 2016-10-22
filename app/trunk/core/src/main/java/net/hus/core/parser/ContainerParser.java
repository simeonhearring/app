package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.Container_;

public class ContainerParser extends ComplexWidgetParser
{
  public ContainerParser()
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