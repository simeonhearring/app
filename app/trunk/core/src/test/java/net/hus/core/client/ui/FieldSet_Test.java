package net.hus.core.client.ui;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FieldSet_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newFieldSet();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static FieldSet_ newFieldSet()
  {
    FieldSet_ ret = new FieldSet_();

    ComplexWidget_Test.initComplexWidget(ret);

    return ret;
  }
}