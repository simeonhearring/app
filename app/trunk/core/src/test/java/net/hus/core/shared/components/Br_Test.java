package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Br_Parser;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.util.ResourceUtil;

public class Br_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newBr();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Br_Parser parser = new Br_Parser();

    Br_ model = Br_Test.newBr();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/Br_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Br_ newBr()
  {
    Br_ ret = new Br_();

    UIObject_Test.initUIObject(ret);

    return ret;
  }
}