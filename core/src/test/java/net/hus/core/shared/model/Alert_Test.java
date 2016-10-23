package net.hus.core.shared.model;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.AlertType;
import org.junit.Before;
import org.junit.Test;

import net.hus.core.shared.model.Alert_;
import net.hus.core.shared.model.UIObject_;

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