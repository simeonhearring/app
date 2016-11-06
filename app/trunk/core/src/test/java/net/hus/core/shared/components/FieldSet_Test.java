package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.FieldSet_Parser;
import net.hus.core.shared.components.FieldSet_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

public class FieldSet_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newFieldSet();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    FieldSet_Parser parser = new FieldSet_Parser();

    FieldSet_ model = FieldSet_Test.newFieldSet();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/FieldSet_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static FieldSet_ newFieldSet()
  {
    FieldSet_ ret = new FieldSet_();

    ComplexWidget_Test.initComplexWidget(ret);

    return ret;
  }
}