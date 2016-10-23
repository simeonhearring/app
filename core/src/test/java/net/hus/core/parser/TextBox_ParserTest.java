package net.hus.core.parser;

import org.junit.Assert;
import org.junit.Test;

import net.hus.core.shared.model.TextBox_;
import net.hus.core.shared.model.TextBox_Test;
import net.hus.core.util.ResourceUtil;

public class TextBox_ParserTest
{
  @Test
  public void test()
  {
    TextBox_Parser parser = new TextBox_Parser();

    TextBox_ model = TextBox_Test.newTextBox();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/TextBox_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}