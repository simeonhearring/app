package net.hus.core.shared.components;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.Alignment;
import org.gwtbootstrap3.client.ui.constants.Emphasis;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.hus.core.parser.Heading_Parser;
import net.hus.core.shared.components.Heading_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

public class Heading_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newHeading();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Heading_Parser parser = new Heading_Parser();

    Heading_ model = Heading_Test.newHeading();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/Heading_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Heading_ newHeading()
  {
    Heading_ ret = new Heading_();
    ret.setText("Text");
    ret.setSubText("SubText");
    ret.setHeadingSize(HeadingSize.H1);
    ret.setAlignment(Alignment.LEFT);
    ret.setEmphasis(Emphasis.INFO);

    ComplexWidget_Test.initComplexWidget(ret);

    return ret;
  }
}