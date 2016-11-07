package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.Typeahead_;
import net.hus.core.shared.components.ValueBoxBase_;

public class Typeahead_Parser extends TextBox_Parser
{
  public Typeahead_Parser()
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
    inXs.alias("Typeahead", Typeahead_.class);
    inXs.aliasField("Value", Typeahead_.class, "mValue");
    inXs.aliasField("Lookup", Typeahead_.class, "mLookup");

    Lookup_Parser.xs(inXs);
  }
}