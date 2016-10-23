package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.ValueBoxBase_;

public class ValueBoxBase_Parser extends FocusWidget_Parser<ValueBoxBase_>
{
  public ValueBoxBase_Parser()
  {
    super();
    xs(this);
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