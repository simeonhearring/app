package net.hus.core.shared.model;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.InputType;
import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.model.Input_;
import net.hus.core.shared.model.UIObject_;

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