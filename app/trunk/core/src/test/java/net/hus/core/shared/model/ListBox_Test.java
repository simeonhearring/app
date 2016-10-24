package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.ListBox_Parser;
import net.hus.core.util.ResourceUtil;

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

  @Test
  public void canParse()
  {
    ListBox_Parser parser = new ListBox_Parser();

    ListBox_ model = ListBox_Test.newListBox();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/ListBox_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static ListBox_ newListBox()
  {
    ListBox_ ret = new ListBox_();
    ret.setMultipleSelect(true);
    ret.add(true, "text1", "value1");
    ret.add(false, "text2", "value2");

    FocusWidget_Test.initFocusWidget(ret);

    return ret;
  }
}