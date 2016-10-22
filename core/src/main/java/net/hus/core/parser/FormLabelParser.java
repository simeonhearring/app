package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.FormLabel_;

public class FormLabelParser extends AbstractTextWidgetParser
{
  public FormLabelParser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    AbstractTextWidgetParser.xs(inXs);
    inXs.alias("FormLabel", FormLabel_.class);
    inXs.aliasAttribute(FormLabel_.class, "mShowRequiredIndicator", "showRequiredIndicator");
  }
}