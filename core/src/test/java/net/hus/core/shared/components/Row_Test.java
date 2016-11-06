package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Row_Parser;
import net.hus.core.shared.components.Row_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

public class Row_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newRow();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Row_Parser parser = new Row_Parser();

    Row_ model = Row_Test.newRow();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/Row_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Row_ newRow()
  {
    Row_ ret = new Row_();

    ComplexWidget_Test.initComplexWidget(ret);

    return ret;
  }
}
