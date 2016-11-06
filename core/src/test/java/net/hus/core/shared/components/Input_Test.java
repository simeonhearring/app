package net.hus.core.shared.components;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.InputType;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Input_Parser;
import net.hus.core.shared.components.Input_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

public class Input_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newInput();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Input_Parser parser = new Input_Parser();

    Input_ model = Input_Test.newInput();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/Input_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Input_ newInput()
  {
    Input_ ret = new Input_();
    ret.setType(InputType.TEXT);
    ret.setMin("MIN");
    ret.setMax("MAX");
    ret.setValue("Value");

    ValueBoxBase_Test.initValueBoxBase(ret);

    return ret;
  }
}