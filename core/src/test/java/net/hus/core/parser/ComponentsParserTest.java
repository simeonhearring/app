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
  public void canParsecLOGIN()
  {
    // xml
    String xml = ResourceUtil.contents("cLOGIN.xml");

    ComponentsParser parser = new ComponentsParser();
    Components model = parser.fromXml(xml);

    Assert.assertEquals(1, model.components().size());
    Assert.assertEquals("LOGIN", model.getFieldTKG().getFvt());
    Assert.assertEquals("LOGIN", model.getFieldTKG().getFgg());
    Assert.assertEquals("LOGIN", model.getFieldTKG().getLayout().name());

    String xexpected = xml.replaceAll("\t", "  ").replaceAll("\" />", "\"/>");
    String xactual = XSD + parser.toXml(model).replaceAll("<Components>", "");

    Assert.assertEquals(xexpected, xactual);

    // json
    String json = ResourceUtil.contents("net/hus/core/parser/cLOGIN.json");

    String jexpected = json.replaceAll("\n", "").replaceAll("\t", "");
    String jactual = parser.toJson(model);
    Assert.assertEquals(jexpected, jactual);
  }

  @Test
  public void canParsecHOME()
  {
    // xml
    String xml = ResourceUtil.contents("cHOME.xml");

    ComponentsParser parser = new ComponentsParser();
    Components model = parser.fromXml(xml);

    Assert.assertEquals(1, model.components().size());
    Assert.assertEquals("ADMIN", model.getFieldTKG().getFvt());
    Assert.assertEquals("ADMIN", model.getFieldTKG().getFgg());
    Assert.assertEquals("HOME", model.getFieldTKG().getLayout().name());

    String xexpected = xml.replaceAll("\t", "  ").replaceAll("\" />", "\"/>");
    String xactual = XSD + parser.toXml(model).replaceAll("<Components>", "");

    Assert.assertEquals(xexpected, xactual);

    // json
    String json = ResourceUtil.contents("net/hus/core/parser/cHOME.json");

    String jexpected = json.replaceAll("\n", "").replaceAll("\t", "");
    String jactual = parser.toJson(model);
    Assert.assertEquals(jexpected, jactual);
  }

  @Test
  public void canParsecLAND()
  {
    // xml
    String xml = ResourceUtil.contents("cLAND.xml");

    ComponentsParser parser = new ComponentsParser();
    Components model = parser.fromXml(xml);

    Assert.assertEquals(3, model.components().size());
    Assert.assertEquals("PERSON", model.getFieldTKG().getFvt());
    Assert.assertEquals("PERSON", model.getFieldTKG().getFgg());
    Assert.assertEquals("WEB", model.getFieldTKG().getLayout().name());
    xml = xml.replaceAll("\t", "  ").replaceAll("\" />", "\"/>");

    Assert.assertEquals(xml, XSD + parser.toXml(model).replaceAll("<Components>", ""));

    String json = ResourceUtil.contents("net/hus/core/parser/cLAND.json");

    String expected = json.replaceAll("\n", "").replaceAll("\t", "");
    String actual = parser.toJson(model);
    // System.out.println(actual);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void canParsecADMIN()
  {
    // xml
    String xml = ResourceUtil.contents("cADMIN.xml");

    ComponentsParser parser = new ComponentsParser();
    Components model = parser.fromXml(xml);

    Assert.assertEquals(0, model.getList().size());
    Assert.assertEquals("ADMIN", model.getFieldTKG().getFvt());
    Assert.assertEquals("ADMIN", model.getFieldTKG().getFgg());
    Assert.assertEquals("ADMIN", model.getFieldTKG().getLayout().name());

    String xexpected = xml.replaceAll("\t", "  ").replaceAll("\" />", "\"/>");
    String xactual = XSD + parser.toXml(model).replaceAll("<Components>", "");

    Assert.assertEquals(xexpected, xactual);

    // json
    String json = "[]";

    String jexpected = json.replaceAll("\n", "").replaceAll("\t", "");
    String jactual = parser.toJson(model);
    Assert.assertEquals(jexpected, jactual);
  }

}