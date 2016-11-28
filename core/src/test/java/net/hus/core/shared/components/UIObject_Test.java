package net.hus.core.shared.components;

import net.hus.core.shared.model.Page.Section;
import net.hus.core.shared.model.UIObject_;

public class UIObject_Test
{
  public static void initUIObject(UIObject_ inOut)
  {
    inOut.setSection(Section.Name.CENTER_01);
    inOut.setKey("KEYLOCATER");
    inOut.setVisible(true);
    inOut.setTitle("Title");
    inOut.setStylePrimaryName("primaryStyle");
    inOut.setPixelSize(10, 15);
    inOut.setId("ID");
    inOut.setStyleName("style");
  }
}