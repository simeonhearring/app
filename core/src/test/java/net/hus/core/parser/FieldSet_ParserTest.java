package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.FieldSet_;
import net.hus.core.shared.model.FieldSet_Test;
import net.hus.core.util.ResourceUtil;

public class FieldSet_ParserTest
{
  @Test
  public void test()
  {
    FieldSet_Parser parser = new FieldSet_Parser();

    FieldSet_ model = FieldSet_Test.newFieldSet();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/FieldSet_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}
