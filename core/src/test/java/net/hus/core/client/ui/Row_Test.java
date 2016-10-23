package net.hus.core.client.ui;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class Row_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newRow();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static Row_ newRow()
  {
    Row_ ret = new Row_();

    ComplexWidget_Test.initComplexWidget(ret);

    return ret;
  }
}
