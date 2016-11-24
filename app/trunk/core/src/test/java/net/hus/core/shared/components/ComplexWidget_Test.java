package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.Pull;

public class ComplexWidget_Test
{
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
