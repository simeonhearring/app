package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.ListBox_;
import net.hus.core.util.ResourceUtil;

public class ListBox_ParserTest
{
  @Test
  public void test()
  {
    ListBox_Parser parser = new ListBox_Parser();

    ListBox_ model = new ListBox_();

    model.add(true, "text1", "value1");
    model.add(false, "text2", "value2");

    model.setLookupParams("A:abc,1:123".split(","));
    model.setTitle("Title");
    model.setPixelSize(10, 20);

    String expected = ResourceUtil.contents("net/hus/core/shared/model/ListBox_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}