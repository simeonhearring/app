package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.ListBox_;
import net.hus.core.util.ResourceUtil;

public class ListBoxParserTest
{
  @Test
  public void test()
  {
    ListBoxParser parser = new ListBoxParser();

    ListBox_ model = new ListBox_();

    model.add(true, "text1", "value1");
    model.add(false, "text2", "value2");

    model.setLookupParams("A:abc,1:123".split(","));
    model.setTitle("Title");
    model.setPixelSize(10, 20);

    String xml = ResourceUtil.contents("net/hus/core/client/ui/ListBox_.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, parser.toXml(model));
  }
}