package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.model.Page;

public class PageParser extends XStream implements Parser<Page>
{
  public PageParser()
  {
    xs((Parser<Page>) this);
  }

  @Override
  public Page fromXml(String inValue)
  {
    return (Page) super.fromXML(inValue);
  }

  @Override
  public String toXml(Page inObj)
  {
    return super.toXML(inObj);
  }

  @Override
  public void xs(Parser<Page> inParser)
  {
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Page", Page.class);
    inXs.aliasAttribute(Page.class, "mName", "name");
    inXs.aliasAttribute(Page.class, "mComponentsName", "components.name");
  }
}