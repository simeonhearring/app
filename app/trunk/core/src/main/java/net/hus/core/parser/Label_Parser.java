package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.Label_;
import net.hus.core.shared.model.UIObject_;

public class Label_Parser extends AbstractTextWidget_Parser
{
  public Label_Parser()
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
    inXs.alias("Label", Label_.class);
    inXs.aliasAttribute(Label_.class, "mLabelType", "labelType");
  }
}