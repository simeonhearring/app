package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.TextBox_;
import net.hus.core.shared.model.ValueBoxBase_;

public class TextBox_Parser extends ValueBoxBase_Parser
{
  public TextBox_Parser()
  {
    xs((Parser<ValueBoxBase_>) this);
  }

  @Override
  public void xs(Parser<ValueBoxBase_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("TextBox", TextBox_.class);
    inXs.aliasField("Value", TextBox_.class, "mValue");
    // inXs.aliasSystemAttribute(null, "class");
  }
}