package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.model.Template;
import net.hus.core.util.ResourceUtil;

public class TemplateParserTest
{
  @Test
  public void test()
  {
    TemplateParser parser = new TemplateParser();

    String xml = ResourceUtil.contents("Template.xml");

    Template model = parser.fromXml(xml);

    Assert.assertEquals("WEB", model.getName());
  }
}