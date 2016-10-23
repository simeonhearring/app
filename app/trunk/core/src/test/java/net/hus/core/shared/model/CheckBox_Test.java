package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.model.CheckBox_;
import net.hus.core.shared.model.UIObject_;

public class CheckBox_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newCheckBox();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static CheckBox_ newCheckBox()
  {
    CheckBox_ ret = new CheckBox_();
    ret.setValue(true);

    ButtonBase_Test.initButtonBase(ret);

    return ret;
  }
}
