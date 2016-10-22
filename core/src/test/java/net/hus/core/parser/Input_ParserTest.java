package net.hus.core.parser;

import org.gwtbootstrap3.client.ui.constants.InputSize;
import org.gwtbootstrap3.client.ui.constants.InputType;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.Input_;
import net.hus.core.util.ResourceUtil;

public class Input_ParserTest
{
  @Test
  public void test()
  {
    Input_Parser parser = new Input_Parser();

    Input_ model = new Input_();
    model.setType(InputType.TEXT);
    model.setValue("Hello");
    model.setTitle("Title");
    model.setPixelSize(10, 20);
    model.setSize(InputSize.LARGE);

    String expected = ResourceUtil.contents("net/hus/core/client/ui/Input_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}