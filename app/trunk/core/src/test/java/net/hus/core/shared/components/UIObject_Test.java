package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.model.Page.Section;

public class UIObject_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newUIObject();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static UIObject_ newUIObject()
  {
    UIObject_ ret = new UIObject_()
    {
      private static final long serialVersionUID = 245365770644359472L;
    };
    initUIObject(ret);
    return ret;
  }

  public static void initUIObject(UIObject_ inOut)
  {
    inOut.setSection(Section.Name.WEBC01);
    inOut.setKey("KEYLOCATER");
    inOut.setVisible(true);
    inOut.setTitle("Title");
    inOut.setStylePrimaryName("primaryStyle");
    inOut.setPixelSize(10, 15);
    inOut.setId("ID");
    inOut.setStyleName("style");
  }
}