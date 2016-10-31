package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.model.Template;

public class TemplateParser extends XStream implements Parser<Template>
{
  public TemplateParser()
  {
    xs(this);
  }

  @Override
  public Template fromXml(String inValue)
  {
    return (Template) super.fromXML(inValue);
  }

  @Override
  public String toXml(Template inObj)
  {
    return super.toXML(inObj);
  }

  @Override
  public void xs(Parser<Template> inParser)
  {
    alias("PageDisplay", Template.class);
    aliasAttribute(Template.class, "mName", "name");
    aliasField("Sections", Template.class, "mSections");

    alias("PageDisplay.Section", Template.Section.class);
    // alias("Display", Field.Display.class);
    // aliasAttribute(Field.Display.class, "mLong", "long");
  }
}