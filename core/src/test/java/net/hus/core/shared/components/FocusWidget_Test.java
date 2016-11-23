package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.model.UIObject_;

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
    FocusWidget_ ret = new FocusWidget_()
    {
      private static final long serialVersionUID = 3315647361517672673L;
    };

    initFocusWidget(ret);

    return ret;
  }

  public static void initFocusWidget(FocusWidget_ inOut)
  {
    UIObject_Test.initUIObject(inOut);
  }
}