package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Components;
import net.hus.core.util.ResourceUtil;

public class ComponentsParserTest
{
  private static final String XSD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
      + "<Components xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"Components.xsd\">";

  @Test
  public void canParseComponents1()
  {
    ComponentsParser parser = new ComponentsParser();

    String xml = ResourceUtil.contents("Components1.xml");

    Components model = parser.fromXml(xml);
    Assert.assertEquals(1, model.components().size());
    xml = xml.replaceAll("\t", "  ").replaceAll("\" />", "\"/>");

    Assert.assertEquals(xml, XSD + parser.toXml(model).replaceAll("<Components>", ""));
  }

  @Test
  public void canParseComponents2()
  {
    ComponentsParser parser = new ComponentsParser();

    String xml = ResourceUtil.contents("Components2.xml");

    Components model = parser.fromXml(xml);
    Assert.assertEquals(3, model.components().size());
    xml = xml.replaceAll("\t", "  ").replaceAll("\" />", "\"/>");

    Assert.assertEquals(xml, XSD + parser.toXml(model).replaceAll("<Components>", ""));
  }

  @Test
  public void canConvertComponents1ToJson()
  {
    ComponentsParser parser = new ComponentsParser();
    String xml = ResourceUtil.contents("Components1.xml");
    Components model = parser.fromXml(xml);

    String json = ResourceUtil.contents("net/hus/core/parser/Components1.json");

    String expected = json.replaceAll("\n", "").replaceAll("\t", "");
    String actual = parser.toJson(model);
    System.out.println(actual);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void canConvertComponents2ToJson()
  {
    ComponentsParser parser = new ComponentsParser();
    String xml = ResourceUtil.contents("Components2.xml");
    Components model = parser.fromXml(xml);

    String json = ResourceUtil.contents("net/hus/core/parser/Components2.json");

    String expected = json.replaceAll("\n", "").replaceAll("\t", "");
    String actual = parser.toJson(model);
    System.out.println(actual);
    Assert.assertEquals(expected, actual);
  }
}