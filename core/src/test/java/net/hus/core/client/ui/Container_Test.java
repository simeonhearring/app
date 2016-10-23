package net.hus.core.client.ui;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class Container_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newContainer();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static Container_ newContainer()
  {
    Container_ ret = new Container_();
    ret.setFluid(true);

    ComplexWidget_Test.initComplexWidget(ret);
    UIObject_Test.initUIObject(ret);

    return ret;
  }
}