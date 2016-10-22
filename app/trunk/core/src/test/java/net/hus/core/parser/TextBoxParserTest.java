package net.hus.core.parser;

import org.gwtbootstrap3.client.ui.constants.InputSize;
import org.junit.Assert;
import org.junit.Test;

import net.hus.core.client.ui.TextBox_;
import net.hus.core.util.ResourceUtil;

public class TextBoxParserTest
{
  @Test
  public void test()
  {
    TextBoxParser parser = new TextBoxParser();

    TextBox_ model = new TextBox_();
    model.setValue("Hello");
    model.setTitle("Title");
    model.setPixelSize(10, 20);
    model.setSize(InputSize.LARGE);

    String xml = ResourceUtil.contents("net/hus/core/client/ui/TextBox_.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, parser.toXml(model));
  }
}