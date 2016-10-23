package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Container_;
import net.hus.core.shared.model.Container_Test;
import net.hus.core.util.ResourceUtil;

public class Container_ParserTest
{
  @Test
  public void test()
  {
    Container_Parser parser = new Container_Parser();

    Container_ model = Container_Test.newContainer();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/Container_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}