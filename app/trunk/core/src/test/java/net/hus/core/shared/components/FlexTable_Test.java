package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.FlexTable_Parser;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.util.ResourceUtil;

public class FlexTable_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newFlexTable();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    FlexTable_Parser parser = new FlexTable_Parser();

    FlexTable_ model = FlexTable_Test.newFlexTable();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/FlexTable_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static FlexTable_ newFlexTable()
  {
    FlexTable_ ret = new FlexTable_();

    UIObject_Test.initUIObject(ret);

    return ret;
  }
}