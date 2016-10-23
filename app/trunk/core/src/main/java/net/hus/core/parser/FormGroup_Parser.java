package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.FormGroup_;

public class FormGroup_Parser extends ComplexPanel_Parser
{
  public FormGroup_Parser()
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