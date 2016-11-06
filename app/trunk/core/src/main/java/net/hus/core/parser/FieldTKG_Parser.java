package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.FieldTKG;

public class FieldTKG_Parser extends XStream implements Parser<FieldTKG>
{
  public FieldTKG_Parser()
  {
    xs((Parser<FieldTKG>) this);
  }

  @Override
  public void xs(Parser<FieldTKG> inParser)
  {
    xs((XStream) inParser);
  }

  @Override
  public FieldTKG fromXml(String inValue)
  {
    return (FieldTKG) super.fromXML(inValue);
  }

  @Override
  public String toXml(FieldTKG inObj)
  {
    return super.toXML(inObj);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("FieldTKG", FieldTKG.class);
    inXs.aliasAttribute(FieldTKG.class, "mFvt", "fvt");
    inXs.aliasAttribute(FieldTKG.class, "mFvk", "fvk");
    inXs.aliasAttribute(FieldTKG.class, "mFgg", "fgg");
    inXs.aliasAttribute(FieldTKG.class, "mPage", "page.name");
  }
}