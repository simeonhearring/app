package net.hus.core.shared.components;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.Pull;
import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.components.AbstractTextWidget_;
import net.hus.core.shared.components.UIObject_;

public class AbstractTextWidget_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newAbstractTextWidget();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static AbstractTextWidget_ newAbstractTextWidget()
  {
    AbstractTextWidget_ ret = new AbstractTextWidget_();

    initAbstractTextWidget(ret);

    return ret;
  }

  public static void initAbstractTextWidget(AbstractTextWidget_ inOut)
  {
    inOut.setText("Text");
    inOut.setColor("red");
    inOut.setMarginBottom(10.0);
    inOut.setMarginLeft(10.0);
    inOut.setMarginRight(10.0);
    inOut.setMarginTop(10.0);
    inOut.setPaddingBottom(10.0);
    inOut.setPaddingLeft(10.0);
    inOut.setPaddingRight(10.0);
    inOut.setPaddingTop(10.0);
    inOut.setPull(Pull.LEFT);

    UIObject_Test.initUIObject(inOut);
  }
}