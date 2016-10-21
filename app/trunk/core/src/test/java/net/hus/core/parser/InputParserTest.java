package net.hus.core.parser;

import org.gwtbootstrap3.client.ui.constants.InputSize;
import org.gwtbootstrap3.client.ui.constants.InputType;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.Input_;
import net.hus.core.util.ResourceUtil;

public class InputParserTest
{
  @Test
  public void test()
  {
    InputParser parser = new InputParser();

    Input_ model = new Input_();
    model.setType(InputType.TEXT);
    model.setValue("Hello");
    model.setTitle("Title");
    model.setPixelSize(10, 20);
    model.setSize(InputSize.LARGE);

    String xml = ResourceUtil.contents("net/hus/core/client/ui/Input_.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, parser.toXml(model));
  }
}