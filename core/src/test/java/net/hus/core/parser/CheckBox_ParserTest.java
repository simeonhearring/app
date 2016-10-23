package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.CheckBox_;
import net.hus.core.shared.model.CheckBox_Test;
import net.hus.core.util.ResourceUtil;

public class CheckBox_ParserTest
{
  @Test
  public void test()
  {
    CheckBox_Parser parser = new CheckBox_Parser();

    CheckBox_ model = CheckBox_Test.newCheckBox();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/CheckBox_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}