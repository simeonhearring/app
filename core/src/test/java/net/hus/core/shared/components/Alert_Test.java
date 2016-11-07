package net.hus.core.shared.components;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.AlertType;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Alert_Parser;
import net.hus.core.shared.components.Alert_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

public class Alert_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newAlert();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Alert_Parser parser = new Alert_Parser();

    Alert_ model = Alert_Test.newAlert();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/Alert_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Alert_ newAlert()
  {
    Alert_ ret = new Alert_();
    ret.setText("Text");
    ret.setType(AlertType.WARNING);
    ret.setDismissable(true);
    ret.setFade(true);

    UIObject_Test.initUIObject(ret);

    return ret;
  }
}