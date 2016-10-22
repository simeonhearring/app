package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.Badge_;
import net.hus.core.client.ui.Badge_Test;
import net.hus.core.util.ResourceUtil;

public class BadgeParserTest
{
  @Test
  public void test()
  {
    BadgeParser parser = new BadgeParser();

    Badge_ model = Badge_Test.newBadge();

    String expected = ResourceUtil.contents("net/hus/core/client/ui/Badge_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}