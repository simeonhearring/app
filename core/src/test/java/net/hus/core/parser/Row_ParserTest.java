package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Row_;
import net.hus.core.shared.model.Row_Test;
import net.hus.core.util.ResourceUtil;

public class Row_ParserTest
{
  @Test
  public void test()
  {
    Row_Parser parser = new Row_Parser();

    Row_ model = Row_Test.newRow();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/Row_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}