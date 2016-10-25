package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.Heading_;

public class Heading_Parser extends ComplexWidget_Parser<Heading_>
{
  public Heading_Parser()
  {
    xs((Parser<Heading_>) this);
  }

  @Override
  public void xs(Parser<Heading_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Heading", Heading_.class);
    inXs.aliasField("Text", Heading_.class, "mText");
    inXs.aliasField("SubText", Heading_.class, "mSubText");
    inXs.aliasAttribute(Heading_.class, "mSize", "size");
    inXs.aliasAttribute(Heading_.class, "mEmphasis", "emphasis");
    inXs.aliasAttribute(Heading_.class, "mAlignment", "alignment");
  }
}