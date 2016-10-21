package net.hus.core.parser;

import org.gwtbootstrap3.client.ui.constants.InputType;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.FieldSet_;
import net.hus.core.client.ui.FormGroup_;
import net.hus.core.client.ui.FormLabel_;
import net.hus.core.client.ui.Input_;
import net.hus.core.util.ResourceUtil;

public class FieldSetParserTest
{

  @Test
  public void test()
  {
    FieldSetParser parser = new FieldSetParser();

    FieldSet_ model = new FieldSet_();

    model.add(group("Field1:", "Hello", InputType.TEXT));
    model.add(group("Field2:", "1234", InputType.NUMBER));

    String xml = ResourceUtil.contents("net/hus/core/client/ui/FieldSet_.xml");
    xml = xml.replaceAll("\t", "  ");

    Assert.assertEquals(xml, parser.toXml(model));
  }

  private FormGroup_ group(String inLabel, String inValue, InputType inType)
  {
    FormGroup_ group = new FormGroup_();

    FormLabel_ label = new FormLabel_();
    label.setText(inLabel);
    group.add(label);

    Input_ input = new Input_();
    input.setValue(inValue);
    input.setType(inType);
    // input.setWidth("100px");
    group.add(input);
    return group;
  }
}
