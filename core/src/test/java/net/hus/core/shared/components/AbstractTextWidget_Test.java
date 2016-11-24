package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.Pull;

public class AbstractTextWidget_Test
{
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