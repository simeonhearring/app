package net.hus.core.shared.components;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.Emphasis;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Icon_Parser;
import net.hus.core.shared.components.Icon_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

public class Icon_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newIcon();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Icon_Parser parser = new Icon_Parser();

    Icon_ model = Icon_Test.newIcon();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/Icon_.xml");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Icon_ newIcon()
  {
    Icon_ ret = new Icon_();
    ret.setType(IconType.AMAZON);
    ret.setSize(IconSize.LARGE);
    ret.setRotate(IconRotate.ROTATE_180);
    ret.setFlip(IconFlip.VERTICAL);
    ret.setEmphasis(Emphasis.DANGER);
    ret.setBorder(true);
    ret.setSpin(true);
    ret.setPulse(true);
    ret.setInverse(true);
    ret.setStackTop(true);
    ret.setStackBase(true);
    ret.setFixedWidth(true);

    ComplexWidget_Test.initComplexWidget(ret);

    return ret;
  }
}