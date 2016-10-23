package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.Column_;
import net.hus.core.client.ui.Column_Test;
import net.hus.core.util.ResourceUtil;

public class Column_ParserTest
{
  @Test
  public void test()
  {
    Column_Parser parser = new Column_Parser();

    Column_ model = Column_Test.newColumn();

    String expected = ResourceUtil.contents("net/hus/core/client/ui/Column_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}