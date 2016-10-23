package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.ComplexWidget_;
import net.hus.core.shared.model.ComplexWidget_Test;
import net.hus.core.util.ResourceUtil;

public class ComplexWidget_ParserTest
{
  @Test
  public void test()
  {
    ComplexWidget_Parser parser = new ComplexWidget_Parser();

    ComplexWidget_ model = ComplexWidget_Test.newComplexWidget();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/ComplexWidget_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}