package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.model.Template;

public class TemplateParser extends XStream implements Parser<Template>
{
  public TemplateParser()
  {
    alias("Template", Template.class);
    aliasAttribute(Template.class, "mName", "name");
    aliasField("Sections", Template.class, "mSections");

    alias("Template.Section", Template.Section.class);
    // alias("Display", Field.Display.class);
    // aliasAttribute(Field.Display.class, "mLong", "long");
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
}