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
  public void testAppProfile()
  {
    Profile model = new Profile();
    model.setPage(new Page(null, Profile.Name.pLOGIN.name()));
    model.setUserName("login");
    model.setFvk("abcd");
    model.setType(Type.APP);

    String xml = ResourceUtil.contents("pLOGIN.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, mParser.toXml(model));
  }

  @Test
  public void testProfile()
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
}