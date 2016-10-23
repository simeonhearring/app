package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Label_;
import net.hus.core.shared.model.Label_Test;
import net.hus.core.util.ResourceUtil;

public class Label_ParserTest
{
  @Test
  public void test()
  {
    Label_Parser parser = new Label_Parser();

    Label_ model = Label_Test.newLabel();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/Label_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}