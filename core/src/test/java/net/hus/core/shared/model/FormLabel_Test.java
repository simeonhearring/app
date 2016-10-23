package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FormLabel_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newFormLabel();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static FormLabel_ newFormLabel()
  {
    FormLabel_ ret = new FormLabel_();
    ret.setShowRequiredIndicator(true);

    AbstractTextWidget_Test.initAbstractTextWidget(ret);

    return ret;
  }
}