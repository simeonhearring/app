package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Hr_Parser;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.util.ResourceUtil;

public class Hr_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newHr();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Hr_Parser parser = new Hr_Parser();

    Hr_ model = Hr_Test.newHr();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/Hr_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Hr_ newHr()
  {
    Hr_ ret = new Hr_();

    UIObject_Test.initUIObject(ret);

    return ret;
  }
}