package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Badge_Parser;
import net.hus.core.shared.components.Badge_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

public class Badge_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newBadge();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Badge_Parser parser = new Badge_Parser();

    Badge_ model = Badge_Test.newBadge();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/Badge_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Badge_ newBadge()
  {
    Badge_ ret = new Badge_();
    ret.setText("Text");

    UIObject_Test.initUIObject(ret);

    return ret;
  }
}
