package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.ListBox_;
import net.hus.core.shared.model.ListBox_Test;
import net.hus.core.util.ResourceUtil;

public class ListBox_ParserTest
{
  @Test
  public void test()
  {
    ListBox_Parser parser = new ListBox_Parser();

    ListBox_ model = ListBox_Test.newListBox();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/ListBox_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}