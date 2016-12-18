package net.hus.core.parser;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.CssFileName;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.Profile;
import net.hus.core.shared.model.Profile.Type;
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
  public void testpLOGIN()
  {
    Profile model = new Profile();
    model.setPage(new Page(null, "cLOGIN"));
    model.setUserName("login");
    model.setFvk("abcd");
    model.setType(Type.NAV);

    String xml = ResourceUtil.contents("nLOGIN.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, mParser.toXml(model));
  }

  @Test
  public void testpADMIN()
  {
    Profile model = new Profile();
    model.setPage(new Page(null, "cADMIN"));
    model.setUserName("admin");
    model.setFvk("abcd");
    model.setType(Type.NAV);

    String xml = ResourceUtil.contents("nADMIN.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, mParser.toXml(model));
  }

  @Test
  public void testpHOME()
  {
    Profile model = new Profile();
    model.setPage(new Page(null, "cHOME"));
    model.setUserName("home");
    model.setFvk("abcd");
    model.setType(Type.NAV);

    String xml = ResourceUtil.contents("nHOME.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, mParser.toXml(model));
  }

  @Test
  public void testProfile3()
  {
    Profile model = new Profile();
    model.setId(3L);
    model.setType(Type.USER);
    model.setFirst("Simeon");
    model.setLast("Hearring");
    model.setMiddle("L");
    model.setPage(new Page(null, "cADMIN"));
    model.setUserName("simeonhearring");
    model.setPassword("abc123");
    model.setCss(CssFileName.united);

    String xml = ResourceUtil.contents("Profile3.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, mParser.toXml(model));

    Assert.assertEquals(model, mParser.fromXml(xml));
  }

  @Test
  public void testProfile6()
  {
    Profile model = new Profile();
    model.setId(6L);
    model.setType(Type.USER);
    model.setFirst("Nadia");
    model.setLast("Hearring");
    model.setMiddle("E");
    model.setPage(new Page(null, "cAPP"));
    model.setUserName("nadiahearring");
    model.setPassword("abc123");
    model.setCss(CssFileName.superhero);
    model.setApps("PEOPLE".split(","));

    String xml = ResourceUtil.contents("Profile6.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, mParser.toXml(model));

    Assert.assertEquals(model, mParser.fromXml(xml));
  }
}