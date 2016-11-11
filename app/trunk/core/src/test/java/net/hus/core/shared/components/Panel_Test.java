package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Panel_Parser;
import net.hus.core.util.ResourceUtil;

public class Panel_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newPanel();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Panel_Parser parser = new Panel_Parser();

    Panel_ model = Panel_Test.newPanel();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/Panel_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Panel_ newPanel()
  {
    Panel_ ret = new Panel_();

    ComplexWidget_Test.initComplexWidget(ret);

    ret.add(new PanelHeader_());
    ret.add(new PanelBody_());
    ret.add(new PanelFooter_());

    return ret;
  }
}