package net.hus.core.shared.components;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.Pull;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.ComplexWidget_Parser;
import net.hus.core.shared.components.ComplexWidget_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

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

  @Test
  public void canParse()
  {
    ComplexWidget_Parser<ComplexWidget_> parser = new ComplexWidget_Parser<>();

    ComplexWidget_ model = ComplexWidget_Test.newComplexWidget();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/ComplexWidget_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static ComplexWidget_ newComplexWidget()
  {
    ComplexWidget_ ret = new ComplexWidget_();

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
