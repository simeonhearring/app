package net.hus.core.shared.components;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.Pull;
import org.junit.Before;
import org.junit.Test;

public class ComplexWidget_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newComplexWidget();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  private static ComplexWidget_ newComplexWidget()
  {
    ComplexWidget_ ret = new ComplexWidget_()
    {
      private static final long serialVersionUID = -1800830808341304712L;
    };

    initComplexWidget(ret);

    return ret;
  }

  public static void initComplexWidget(ComplexWidget_ inObj)
  {
    inObj.setColor("red");
    inObj.setMarginBottom(10.0);
    inObj.setMarginLeft(10.0);
    inObj.setMarginRight(10.0);
    inObj.setMarginTop(10.0);
    inObj.setPaddingBottom(10.0);
    inObj.setPaddingLeft(10.0);
    inObj.setPaddingRight(10.0);
    inObj.setPaddingTop(10.0);
    inObj.setPull(Pull.LEFT);

    UIObject_Test.initUIObject(inObj);
  }
}
