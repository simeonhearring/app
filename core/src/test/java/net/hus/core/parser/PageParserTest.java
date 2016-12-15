package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Page;

public class PageParserTest
{
  @Test
  public void test()
  {
    PageParser parser = new PageParser();

    String xml = "<Page layout=\"LOGIN\" components.name=\"cLOGIN\"/>";

    Page model = parser.fromXml(xml);

    Assert.assertEquals(Page.Layout.LOGIN, model.getLayout());
    Assert.assertEquals("Components1", model.getComponentsName());

    Assert.assertEquals(xml, parser.toXML(model));
  }
}