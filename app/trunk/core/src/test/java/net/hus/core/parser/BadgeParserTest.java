package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.Badge_;
import net.hus.core.util.ResourceUtil;

public class BadgeParserTest
{
  @Test
  public void test()
  {
    BadgeParser parser = new BadgeParser();

    Badge_ model = new Badge_("Hello");
    model.setTitle("Title");
    model.setStylePrimaryName("primary style");
    model.setPixelSize(10, 20);

    String xml = ResourceUtil.contents("net/hus/core/client/ui/Badge_.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, parser.toXml(model));
  }
}