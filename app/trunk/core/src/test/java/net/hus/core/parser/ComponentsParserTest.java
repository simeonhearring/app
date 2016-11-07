package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.components.Components;
import net.hus.core.util.ResourceUtil;

public class ComponentsParserTest
{
  @Test
  public void canParse()
  {
    ComponentsParser parser = new ComponentsParser();

    String xml = ResourceUtil.contents("Components1.xml");

    String x =
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<Components xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"Components.xsd\">";
    Components model = parser.fromXml(xml);
    Assert.assertEquals(1, model.components().size());
    xml = xml.replaceAll("\t", "  ").replaceAll("\" />", "\"/>");

    Assert.assertEquals(xml, x + parser.toXml(model).replaceAll("<Components>", ""));
  }
}