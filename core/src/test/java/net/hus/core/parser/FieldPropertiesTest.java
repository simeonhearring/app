package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.model.Field;

public class FieldPropertiesTest
{
  @Test
  public void testParsing()
  {
    FieldProperties parser = new FieldProperties();

    Field.Properties prop = new Field.Properties();
    prop.setDisplay("Name");

    StringBuilder sb = new StringBuilder();
    sb.append("<Field.Properties>\n");
    sb.append("  <Display>Name</Display>\n");
    sb.append("</Field.Properties>");

    Assert.assertEquals(sb.toString(), parser.toXml(prop));
  }
}