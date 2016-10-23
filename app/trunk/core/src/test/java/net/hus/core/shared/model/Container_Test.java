package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.model.Container_;
import net.hus.core.shared.model.UIObject_;

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

    return ret;
  }
}