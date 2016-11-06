package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.FormLabel_;
import net.hus.core.shared.components.UIObject_;

public class FormLabel_Parser extends AbstractTextWidget_Parser
{
  public FormLabel_Parser()
  {
    xs((Parser<UIObject_>) this);
  }

  @Override
  public void xs(Parser<UIObject_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("FormLabel", FormLabel_.class);
    inXs.aliasAttribute(FormLabel_.class, "mShowRequiredIndicator", "showRequiredIndicator");
  }
}