package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.Alert_;
import net.hus.core.client.ui.Alert_Test;
import net.hus.core.util.ResourceUtil;

public class AlertParserTest
{
  @Test
  public void test()
  {
    AlertParser parser = new AlertParser();

    Alert_ model = Alert_Test.newAlert();

    String expected = ResourceUtil.contents("net/hus/core/client/ui/Alert_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}