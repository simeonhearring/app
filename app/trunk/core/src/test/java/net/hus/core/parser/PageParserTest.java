package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.model.Page;
import net.hus.core.util.ResourceUtil;

public class PageParserTest
{
  @Test
  public void test()
  {
    PageParser parser = new PageParser();

    String xml = ResourceUtil.contents("Page.xml");

    Page model = parser.fromXml(xml);

    Assert.assertEquals("LOGIN", model.getName());
  }
}