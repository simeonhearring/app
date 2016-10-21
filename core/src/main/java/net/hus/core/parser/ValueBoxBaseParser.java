package net.hus.core.parser;

import net.hus.core.client.ui.ValueBoxBase_;

public class ValueBoxBaseParser<V> extends UIObjectParser<ValueBoxBase_<V>>
{
  public ValueBoxBaseParser()
  {
    super();

    alias("ValueBoxBase", ValueBoxBase_.class);
    aliasField("Value", ValueBoxBase_.class, "mValue");
    aliasAttribute(ValueBoxBase_.class, "mAllowBlank", "allowBlank");
    aliasAttribute(ValueBoxBase_.class, "mAutoComplete", "autoComplete");
    aliasAttribute(ValueBoxBase_.class, "mMaxLength", "maxLength");
    aliasAttribute(ValueBoxBase_.class, "mSize", "size");
  }
}