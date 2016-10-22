package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.FormLabel_;

public class FormLabel_Parser extends AbstractTextWidget_Parser
{
  public FormLabel_Parser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    AbstractTextWidget_Parser.xs(inXs);
    inXs.alias("FormLabel", FormLabel_.class);
    inXs.aliasAttribute(FormLabel_.class, "mShowRequiredIndicator", "showRequiredIndicator");
  }
}