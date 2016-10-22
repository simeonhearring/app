package net.hus.core.client.ui;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ButtonBase_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newButtonBase();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static ButtonBase_ newButtonBase()
  {
    ButtonBase_ ret = new ButtonBase_();
    initButtonBase(ret);
    return ret;
  }

  public static void initButtonBase(ButtonBase_ inOut)
  {
    inOut.setText("Text");
    UIObject_Test.initUIObject(inOut);
  }
}
