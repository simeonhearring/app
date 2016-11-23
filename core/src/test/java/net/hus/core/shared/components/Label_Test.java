package net.hus.core.shared.components;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.LabelType;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Label_Parser;
import net.hus.core.shared.components.Label_;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.util.ResourceUtil;

public class Label_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newLabel();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Label_Parser parser = new Label_Parser();

    Label_ model = Label_Test.newLabel();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/Label_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Label_ newLabel()
  {
    Label_ ret = new Label_();
    ret.setLabelType(LabelType.DANGER);

    AbstractTextWidget_Test.initAbstractTextWidget(ret);

    return ret;
  }
}