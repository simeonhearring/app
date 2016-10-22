package net.hus.core.client.ui;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class Badge_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newBadge();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static Badge_ newBadge()
  {
    Badge_ ret = new Badge_();
    ret.setText("Text");

    UIObject_Test.initUIObject(ret);

    return ret;
  }
}
