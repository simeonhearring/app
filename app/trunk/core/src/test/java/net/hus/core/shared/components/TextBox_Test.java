package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.hus.core.parser.TextBox_Parser;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.util.ResourceUtil;

public class TextBox_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newTextBox();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    TextBox_Parser parser = new TextBox_Parser();

    TextBox_ model = TextBox_Test.newTextBox();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/TextBox_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static TextBox_ newTextBox()
  {
    TextBox_ ret = new TextBox_();

    initTextBox(ret);

    return ret;
  }

  public static void initTextBox(TextBox_ inTextBox)
  {
    inTextBox.setValue("Value");
    ValueBoxBase_Test.initValueBoxBase(inTextBox);
  }

  public static TextBox_ newTextBox(String inKey)
  {
    TextBox_ ret = newTextBox();

    ret.setKey(inKey);

    return ret;
  }
}