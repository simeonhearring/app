package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.Properties;

public class FieldPropertiesParser extends XStream implements Parser<Field.Properties>
{
  public FieldPropertiesParser()
  {
    xs(this);
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

  @Override
  public void xs(Parser<Properties> inParser)
  {
    alias("Field.Properties", Field.Properties.class);
    aliasField("Type", Field.Properties.class, "mType");
    aliasField("Display", Field.Properties.class, "mDisplay");
    aliasField("Lookup", Field.Properties.class, "mLookup");
    aliasField("Array", Field.Properties.class, "mArray");
    aliasField("Database", Field.Properties.class, "mDatabase");

    alias("Display", Field.Display.class);
    aliasAttribute(Field.Display.class, "mShort", "short");
    aliasAttribute(Field.Display.class, "mLong", "long");

    alias("Lookup", Field.Lookup.class);
    aliasAttribute(Field.Lookup.class, "mLocation", "loc");
    aliasAttribute(Field.Lookup.class, "mParameters", "params");

    alias("Array", Field.Array.class);
    aliasAttribute(Field.Array.class, "mSize", "size");
    aliasAttribute(Field.Array.class, "mLabels", "Labels");

    alias("Database", Field.Database.class);
    aliasAttribute(Field.Database.class, "mOneValue", "oneValue");
  }
}