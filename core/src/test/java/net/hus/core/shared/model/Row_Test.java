package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.model.Row_;
import net.hus.core.shared.model.UIObject_;

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
