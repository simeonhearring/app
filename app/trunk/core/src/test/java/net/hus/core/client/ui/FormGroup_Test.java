package net.hus.core.client.ui;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.FormGroupSize;
import org.gwtbootstrap3.client.ui.constants.ValidationState;
import org.junit.Before;
import org.junit.Test;

public class FormGroup_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newFormGroup();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static FormGroup_ newFormGroup()
  {
    FormGroup_ ret = new FormGroup_();
    initFormGroup(ret);
    return ret;
  }

  public static void initFormGroup(FormGroup_ inOut)
  {
    inOut.setSize(FormGroupSize.LARGE);
    inOut.setState(ValidationState.SUCCESS);

    UIObject_Test.initUIObject(inOut);
  }
}
