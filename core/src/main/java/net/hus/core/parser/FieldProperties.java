package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.model.Field;
import net.hus.core.model.Field.Properties;

public class FieldProperties extends XStream implements Parser<Field.Properties>
{
  public FieldProperties()
  {
    alias("Field.Properties", Field.Properties.class);
    aliasField("Display", Field.Properties.class, "mDisplay");

    alias("Display", Field.Display.class);
    aliasAttribute(Field.Display.class, "mShort", "short");
    aliasAttribute(Field.Display.class, "mLong", "long");
  }

  @Override
  public Properties fromXml(String inValue)
  {
    return (Properties) super.fromXML(inValue);
  }

  @Override
  public String toXml(Properties inObj)
  {
    return super.toXML(inObj);
  }
}