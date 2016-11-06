package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.ValueBoxBase_;

public class ValueBoxBase_Parser extends FocusWidget_Parser<ValueBoxBase_>
{
  public ValueBoxBase_Parser()
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
    inXs.alias("ValueBoxBase", ValueBoxBase_.class);
    inXs.aliasField("Placeholder", ValueBoxBase_.class, "mPlaceholder");
    inXs.aliasAttribute(ValueBoxBase_.class, "mAllowBlank", "allowBlank");
    inXs.aliasAttribute(ValueBoxBase_.class, "mAutoComplete", "autoComplete");
    inXs.aliasAttribute(ValueBoxBase_.class, "mMaxLength", "maxLength");
    inXs.aliasAttribute(ValueBoxBase_.class, "mSize", "size");
  }
}