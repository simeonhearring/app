package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.model.UIObject_Test;
import net.hus.core.util.ResourceUtil;

public class UIObject_ParserTest
{
  @Test
  public void test()
  {
    UIObject_Parser<UIObject_> parser = new UIObject_Parser<>();

    UIObject_ model = UIObject_Test.newUIObject();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/UIObject_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}