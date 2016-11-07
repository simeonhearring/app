package net.hus.core.parser;

import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.Array;
import net.hus.core.shared.model.Field.Database;
import net.hus.core.shared.model.Field.DateTime;
import net.hus.core.shared.model.Field.Display;
import net.hus.core.shared.model.Field.Lookup;
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

    prop.setDisplay(new Display());
    prop.getDisplay().setLong("Name");
    prop.getDisplay().setShort("Nme");

    Lookup loc = new Lookup();
    loc.setLocation(Location.TABLE);
    loc.setParameters("GENDER");
    prop.setLookupGroup(loc);

    Array array = new Array();
    array.setSize(5);
    array.setLabels("Street A,Street B,City,State,Zip".split(","));
    prop.setArray(array);

    array.setProperties(new Array.Properties(10, true, "#CCC", "#FFF", HeadingSize.H2));

    Database database = new Database();
    database.setOneValue(true);
    prop.setDatabase(database);

    prop.setDateTime(new DateTime("yyyy-MM-dd"));

    String xml = ResourceUtil.contents("net/hus/core/parser/FieldProperties.xml");

    Assert.assertEquals(xml, parser.toXml(prop));
  }
}