package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.model.FocusWidget_;
import net.hus.core.shared.model.UIObject_;

public class FocusWidget_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newValueBoxBase();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static FocusWidget_ newValueBoxBase()
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