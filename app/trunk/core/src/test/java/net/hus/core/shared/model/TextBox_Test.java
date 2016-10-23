package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TextBox_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newTextBox();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static TextBox_ newTextBox()
  {
    TextBox_ ret = new TextBox_();
    ret.setValue("Value");

    ValueBoxBase_Test.initValueBoxBase(ret);

    return ret;
  }
}
