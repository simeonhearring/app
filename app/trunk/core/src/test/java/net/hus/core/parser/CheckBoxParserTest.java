package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.CheckBox_;
import net.hus.core.client.ui.CheckBox_Test;
import net.hus.core.util.ResourceUtil;

public class CheckBoxParserTest
{
  @Test
  public void test()
  {
    CheckBoxParser parser = new CheckBoxParser();

    CheckBox_ model = CheckBox_Test.newCheckBox();

    String expected = ResourceUtil.contents("net/hus/core/client/ui/CheckBox_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}