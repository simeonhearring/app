package net.hus.core.shared.components;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.constants.FormGroupSize;
import org.gwtbootstrap3.client.ui.constants.ValidationState;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.FormGroup_Parser;
import net.hus.core.shared.components.FormGroup_;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.util.ResourceUtil;

public class FormGroup_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newFormGroup();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    FormGroup_Parser parser = new FormGroup_Parser();

    FormGroup_ model = FormGroup_Test.newFormGroup();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/FormGroup_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static FormGroup_ newFormGroup()
  {
    FormGroup_ ret = new FormGroup_();
    initFormGroup(ret);
    return ret;
  }

  public static void initFormGroup(FormGroup_ inOut)
  {
    inOut.setSize(FormGroupSize.LARGE);
    inOut.setState(ValidationState.SUCCESS);

    UIObject_Test.initUIObject(inOut);
  }
}
