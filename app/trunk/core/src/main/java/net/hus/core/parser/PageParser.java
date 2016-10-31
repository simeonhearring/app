package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.model.Page;

public class PageParser extends XStream implements Parser<Page>
{
  public PageParser()
  {
    xs(this);
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
    alias("Page", Page.class);
    aliasAttribute(Page.class, "mName", "name");
    aliasAttribute(Page.class, "mComponentsName", "components.name");
    aliasField("Sections", Page.class, "mSections");

    alias("Page.Section", Page.Section.class);
  }
}