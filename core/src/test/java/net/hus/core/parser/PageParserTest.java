package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Page;
import net.hus.core.util.ResourceUtil;

public class PageParserTest
{
  @Test
  public void test()
  {
    PageParser parser = new PageParser();

    String xml = ResourceUtil.contents("Page.xml");

    Page model = parser.fromXml(xml);

    Assert.assertEquals(Page.Layout.LOGIN, model.getLayout());
    Assert.assertEquals("Components1", model.getComponentsName());

    Assert.assertEquals(xml, parser.toXML(model));
  }
}