package net.hus.core.shared.model;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.FormLabel_Parser;
import net.hus.core.util.ResourceUtil;

public class FormLabel_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newFormLabel();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    FormLabel_Parser parser = new FormLabel_Parser();

    FormLabel_ model = FormLabel_Test.newFormLabel();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/FormLabel_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static FormLabel_ newFormLabel()
  {
    FormLabel_ ret = new FormLabel_();
    ret.setShowRequiredIndicator(true);

    AbstractTextWidget_Test.initAbstractTextWidget(ret);

    return ret;
  }
}