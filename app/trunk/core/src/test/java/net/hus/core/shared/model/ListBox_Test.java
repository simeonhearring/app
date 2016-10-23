package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ListBox_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newListBox();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  public static ListBox_ newListBox()
  {
    ListBox_ ret = new ListBox_();
    ret.setMultipleSelect(true);
    ret.setLookupParams("a:123,b:456".split(","));
    ret.add(true, "text1", "value1");
    ret.add(false, "text2", "value2");

    FocusWidget_Test.initFocusWidget(ret);

    return ret;
  }
}