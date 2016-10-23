package net.hus.core.parser;

import org.gwtbootstrap3.client.ui.constants.InputSize;
import org.junit.Assert;
import org.junit.Test;

import net.hus.core.shared.model.TextBox_;
import net.hus.core.util.ResourceUtil;

public class TextBox_ParserTest
{
  @Test
  public void test()
  {
    TextBox_Parser parser = new TextBox_Parser();

    TextBox_ model = new TextBox_();
    model.setValue("Hello");
    model.setTitle("Title");
    model.setPixelSize(10, 20);
    model.setSize(InputSize.LARGE);

    String expected = ResourceUtil.contents("net/hus/core/shared/model/TextBox_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}