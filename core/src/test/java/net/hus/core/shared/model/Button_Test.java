package net.hus.core.shared.model;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.BadgePosition;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Toggle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.hus.core.parser.Button_Parser;
import net.hus.core.util.ResourceUtil;

public class Button_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newButton();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Button_Parser parser = new Button_Parser();

    Button_ model = Button_Test.newButton();

    String expected = ResourceUtil.contents("net/hus/core/shared/model/Button_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Button_ newButton()
  {
    Button_ ret = new Button_();
    ret.setText("text");
    ret.setIconType(IconType.ADJUST);
    ret.setToggleCaret(true);
    ret.setDataToggle(Toggle.BUTTON);
    ret.setButtonType(ButtonType.DANGER);
    ret.setIconPosition(IconPosition.LEFT);
    ret.setIconSize(IconSize.LARGE);
    ret.setIconFlip(IconFlip.HORIZONTAL);
    ret.setIconRotate(IconRotate.NONE);
    ret.setIconBordered(true);
    ret.setIconInverse(true);
    ret.setIconSpin(true);
    ret.setIconPulse(true);
    ret.setIconFixedWidth(true);
    ret.setBadgeText("badgeText");
    ret.setBadgePosition(BadgePosition.LEFT);
    ret.setActive(true);
    ret.setEnabled(true);
    ret.setButtonSize(ButtonSize.DEFAULT);
    ret.setIconSize(IconSize.LARGE);
    ret.setCommandName("LoginCommand");

    ComplexWidget_Test.initComplexWidget(ret);

    return ret;
  }
}
