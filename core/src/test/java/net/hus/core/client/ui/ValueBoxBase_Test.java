package net.hus.core.client.ui;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.InputSize;
import org.junit.Before;
import org.junit.Test;

public class ValueBoxBase_Test
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

  public static ValueBoxBase_ newValueBoxBase()
  {
    ValueBoxBase_ ret = new ValueBoxBase_();

    initValueBoxBase(ret);

    return ret;
  }

  public static void initValueBoxBase(ValueBoxBase_ inOut)
  {
    inOut.setAllowBlank(true);
    inOut.setAutoComplete(true);
    inOut.setMaxLength(10);
    inOut.setPlaceholder("placeholder");
    inOut.setSize(InputSize.LARGE);

    FocusWidget_Test.initFocusWidget(inOut);
  }
}