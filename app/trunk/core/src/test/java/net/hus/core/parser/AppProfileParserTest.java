package net.hus.core.parser;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.AppProfile;
import net.hus.core.shared.model.Page;
import net.hus.core.util.ResourceUtil;

public class AppProfileParserTest
{
  private AppProfileParser mParser;

  @Before
  public void before()
  {
    mParser = new AppProfileParser();
  }

  @Test
  public void test0()
  {
    AppProfile model = new AppProfile();
    model.setPage(new Page(null, "Components1"));
    model.setFvk("abcd");

    String xml = ResourceUtil.contents("Profile0.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, mParser.toXml(model));
  }
}