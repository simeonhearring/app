package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.components.FocusWidget_;
import net.hus.core.shared.components.UIObject_;

public class FocusWidget_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newFocusWidget();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static FocusWidget_ newFocusWidget()
  {
    FocusWidget_ ret = new FocusWidget_();

    initFocusWidget(ret);

    return ret;
  }

  public static void initFocusWidget(FocusWidget_ inOut)
  {
    UIObject_Test.initUIObject(inOut);
  }
}