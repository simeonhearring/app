package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.model.TableKey;
import net.hus.core.parser.UIObject_Parser;
import net.hus.core.util.ResourceUtil;

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

  @Test
  public void canParse()
  {
    UIObject_Parser<UIObject_> parser = new UIObject_Parser<>();

    UIObject_ model = UIObject_Test.newUIObject();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/UIObject_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static UIObject_ newUIObject()
  {
    UIObject_ ret = new UIObject_();
    initUIObject(ret);
    return ret;
  }

  public static void initUIObject(UIObject_ inOut)
  {
    inOut.setTableKey(new TableKey("PERSON", "JUNIT"));
    inOut.setSection("WEB01");
    inOut.setKey("KEYLOCATER");
    inOut.setVisible(true);
    inOut.setTitle("Title");
    inOut.setStylePrimaryName("primaryStyle");
    inOut.setPixelSize(10, 15);
    inOut.setId("ID");
    inOut.setStyleName("style");
  }
}