package net.hus.core.parser;

import org.gwtbootstrap3.client.ui.constants.InputType;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.Container_;
import net.hus.core.client.ui.FieldSet_;
import net.hus.core.client.ui.FormGroup_;
import net.hus.core.client.ui.FormLabel_;
import net.hus.core.client.ui.Input_;
import net.hus.core.util.ResourceUtil;

public class Container_ParserTest
{

  @Test
  public void test()
  {
    Container_Parser parser = new Container_Parser();

    Container_ model = new Container_();
    model.setFluid(true);

    FieldSet_ fieldset = new FieldSet_();

    fieldset.add(group("Field1:", "Hello", InputType.TEXT));

    String xml = ResourceUtil.contents("net/hus/core/client/ui/Container_.xml");
    xml = xml.replaceAll("\t", "  ");

    model.add(fieldset);

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
    group.add(input);
    return group;
  }
}
