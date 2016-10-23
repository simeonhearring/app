package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.model.UIObject_;

public class UIObject_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newUIObject();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static UIObject_ newUIObject()
  {
    UIObject_ ret = new UIObject_();
    initUIObject(ret);
    return ret;
  }

  public static void initUIObject(UIObject_ inOut)
  {
    inOut.setKey("KEYLOCATER");
    inOut.setVisible(true);
    inOut.setTitle("Title");
    inOut.setStylePrimaryName("primaryStyle");
    inOut.setPixelSize(10, 15);
    inOut.setId("ID");
    inOut.setStyleName("style");
  }
}