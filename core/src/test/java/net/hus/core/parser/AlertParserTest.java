package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.Alert_;
import net.hus.core.util.ResourceUtil;

public class AlertParserTest
{
  @Test
  public void test()
  {
    AlertParser parser = new AlertParser();

    Alert_ model = new Alert_("Hello");
    model.setTitle("Title");
    model.setStylePrimaryName("primary style");
    model.setPixelSize(10, 20);

    String xml = ResourceUtil.contents("net/hus/core/client/ui/Alert_.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, parser.toXml(model));
  }
}