package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.CheckBox_Parser;
import net.hus.core.shared.components.CheckBox_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

public class CheckBox_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newCheckBox();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    CheckBox_Parser parser = new CheckBox_Parser();

    CheckBox_ model = CheckBox_Test.newCheckBox();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/CheckBox_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static CheckBox_ newCheckBox()
  {
    CheckBox_ ret = new CheckBox_();
    ret.setValue(true);

    ButtonBase_Test.initButtonBase(ret);

    return ret;
  }
}
