package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.model.Field;
import net.hus.core.model.Field.Display;
import net.hus.core.model.Field.Lookup;
import net.hus.core.model.Field.Lookup.Location;
import net.hus.core.util.ResourceUtil;

public class FieldPropertiesParserTest
{
  @Test
  public void testParsing()
  {
    FieldPropertiesParser parser = new FieldPropertiesParser();

    Field.Properties prop = new Field.Properties();
    prop.setDisplay(new Display());
    prop.getDisplay().setLong("Name");
    prop.getDisplay().setShort("Nme");

    Lookup loc = new Lookup();
    loc.setLocation(Location.TABLE);
    loc.setParameters("GENDER");
    prop.setLookupGroup(loc);

    String xml = ResourceUtil.contents("net/hus/core/parser/FieldProperties.xml");

    Assert.assertEquals(xml, parser.toXml(prop));
  }
}