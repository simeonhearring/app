package net.hus.core.shared.model;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.LabelType;
import org.junit.Before;
import org.junit.Test;

public class Label_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newLabel();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static Label_ newLabel()
  {
    Label_ ret = new Label_();
    ret.setLabelType(LabelType.DANGER);

    AbstractTextWidget_Test.initAbstractTextWidget(ret);

    return ret;
  }
}