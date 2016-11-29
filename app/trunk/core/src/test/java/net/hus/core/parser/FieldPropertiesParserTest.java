package net.hus.core.parser;

import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.Array;
import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.shared.model.Field.Type;
import net.hus.core.util.ResourceUtil;

public class FieldPropertiesParserTest
{
  @Test
  public void testParsing()
  {
    FieldPropertiesParser parser = new FieldPropertiesParser();

    Field.Properties prop = new Field.Properties();
    prop.setType(Type.NUMBER);

    prop.getDisplay().setLong("Name");
    prop.getDisplay().setShort("Nme");

    prop.getLookup().setLocation(Location.TABLE);
    prop.getLookup().setParameters("GENDER");

    prop.getArray().setSize(5);
    prop.getArray().setLabels("Street A,Street B,City,State,Zip".split(","));
    prop.getArray().setFields("1,2,3,4,5".split(","));

    prop.getArray()
        .setProperties(new Array.Properties(500, 10, true, "#CCC", "#FFF", HeadingSize.H2));

    prop.getDatabase().setOneValue(true);

    prop.getDateTime().setFormat("yyyy-MM-dd");

    String xml = ResourceUtil.contents("net/hus/core/parser/FieldProperties.xml");

    Assert.assertEquals(xml, parser.toXml(prop));
  }
}