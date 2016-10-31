package net.hus.core.parser;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.model.Profile;
import net.hus.core.util.ResourceUtil;

public class ProfileParserTest
{
  private ProfileParser mParser;

  @Before
  public void before()
  {
    mParser = new ProfileParser();
  }

  @Test
  public void test()
  {
    Profile model = new Profile();
    model.setId(1L);
    model.setFirst("Simeon");
    model.setLast("Hearring");
    model.setMiddle("L");
    model.setLandingPage("Page1.xml");
    model.setUserName("simeonhearring");
    model.setPassword("abc123");

    String xml = ResourceUtil.contents("Profile1.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, mParser.toXml(model));
    System.out.println(mParser.toXml(model));
  }
}