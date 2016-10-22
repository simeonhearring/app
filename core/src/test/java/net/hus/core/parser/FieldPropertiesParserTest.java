package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.model.Field;
import net.hus.core.model.Field.Display;

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

    StringBuilder sb = new StringBuilder();
    sb.append("<Field.Properties>\n");
    sb.append("  <Display long=\"Name\" short=\"Nme\"/>\n");
    sb.append("</Field.Properties>");

    Assert.assertEquals(sb.toString(), parser.toXml(prop));
  }
}