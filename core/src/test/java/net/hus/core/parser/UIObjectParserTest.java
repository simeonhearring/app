package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.UIObject_;
import net.hus.core.client.ui.UIObject_Test;
import net.hus.core.util.ResourceUtil;

public class UIObjectParserTest
{
  @Test
  public void test()
  {
    UIObjectParser<UIObject_> parser = new UIObjectParser<>();

    UIObject_ model = UIObject_Test.newUIObject();

    String expected = ResourceUtil.contents("net/hus/core/client/ui/UIObject_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}