package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.FormGroup_;

public class FormGroup_Parser extends ComplexPanel_Parser<FormGroup_>
{
  public FormGroup_Parser()
  {
    super();
    xs((Parser<FormGroup_>) this);
  }

  @Override
  public void xs(Parser<FormGroup_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("FormGroup", FormGroup_.class);
    inXs.aliasAttribute(FormGroup_.class, "mSize", "size");
    inXs.aliasAttribute(FormGroup_.class, "mState", "state");
  }
}