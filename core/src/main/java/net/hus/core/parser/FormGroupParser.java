package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.FormGroup_;

public class FormGroupParser extends ComplexPanelParser
{
  public FormGroupParser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("FormGroup", FormGroup_.class);
    inXs.aliasAttribute(FormGroup_.class, "mSize", "size");
    inXs.aliasAttribute(FormGroup_.class, "mState", "state");
  }
}