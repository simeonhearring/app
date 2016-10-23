package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.Label_;

public class Label_Parser extends AbstractTextWidget_Parser
{
  public Label_Parser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    AbstractTextWidget_Parser.xs(inXs);
    inXs.alias("Label", Label_.class);
    inXs.aliasAttribute(Label_.class, "mLabelType", "labelType");
  }
}