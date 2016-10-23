package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.Input_;
import net.hus.core.client.ui.Input_Test;
import net.hus.core.util.ResourceUtil;

public class Input_ParserTest
{
  @Test
  public void test()
  {
    Input_Parser parser = new Input_Parser();

    Input_ model = Input_Test.newInput();

    String expected = ResourceUtil.contents("net/hus/core/client/ui/Input_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}