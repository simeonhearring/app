package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.DatePicker_Parser;
import net.hus.core.util.ResourceUtil;

public class DatePicker_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newDatePicker();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    DatePicker_Parser parser = new DatePicker_Parser();

    DatePicker_ model = DatePicker_Test.newDatePicker();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/DatePicker_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static DatePicker_ newDatePicker()
  {
    DatePicker_ ret = new DatePicker_();


    UIObject_Test.initUIObject(ret);

    return ret;
  }
}