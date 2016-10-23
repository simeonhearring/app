package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.FormLabel_;
import net.hus.core.shared.model.FormLabel_Test;
import net.hus.core.util.ResourceUtil;

public class FormLabel_ParserTest
{
  @Test
  public void test()
  {
    FormLabel_Parser parser = new FormLabel_Parser();

    FormLabel_ model = FormLabel_Test.newFormLabel();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/FormLabel_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}