package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Container_Parser;
import net.hus.core.shared.components.Container_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

public class Container_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newContainer();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Container_Parser parser = new Container_Parser();

    Container_ model = Container_Test.newContainer();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/Container_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Container_ newContainer()
  {
    Container_ ret = new Container_();
    ret.setFluid(true);

    ComplexWidget_Test.initComplexWidget(ret);

    return ret;
  }
}