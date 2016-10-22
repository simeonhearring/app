package net.hus.core.server.command;

import org.gwtbootstrap3.client.ui.constants.InputType;

import net.hus.core.client.ui.CheckBox_;
import net.hus.core.client.ui.FieldSet_;
import net.hus.core.client.ui.FormGroup_;
import net.hus.core.client.ui.FormLabel_;
import net.hus.core.client.ui.Input_;
import net.hus.core.client.ui.ListBox_;
import net.hus.core.client.ui.TextBox_;
import net.hus.core.client.ui.UIObject_;
import net.hus.core.parser.FieldSetParser;
import net.hus.core.shared.command.UIObjectCommand;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.ResourceUtil;

public class UIObjectCommandBean extends AbstractCommandBean<UIObjectCommand<?>>
{
  @Override
  public RpcResponse execute(UIObjectCommand<?> inCommand)
  {
    String xml = ResourceUtil.contents("net/hus/core/client/ui/Page.xml");

    FieldSetParser parser = new FieldSetParser();

    FieldSet_ set = (FieldSet_) parser.fromXml(xml);

    // FieldSet_ set = new FieldSet_();
    //
    // set.add(group("Field1:", input("Hello")));
    //
    // set.add(group("Field2:", input("World")));
    //
    // set.add(group("Field3:", textbox("textbox")));
    //
    // set.add(group("Field4:", listbox("", "value1", "value2", "value3")));
    //
    // set.add(group("Field5:", checkbox("checkbox", true)));

    System.out.println(parser.toXML(set));
    inCommand.setData(set);

    return inCommand;
  }

  private FormGroup_ group(String inLabel, UIObject_ inUiO)
  {
    FormGroup_ ret = new FormGroup_();

    FormLabel_ label = new FormLabel_();
    label.setText(inLabel);
    ret.add(label);

    ret.add(inUiO);

    return ret;
  }

  private Input_ input(String inValue)
  {
    Input_ ret = new Input_();
    ret.setValue(inValue);
    ret.setType(InputType.TEXT);
    return ret;
  }

  private TextBox_ textbox(String inValue)
  {
    TextBox_ ret = new TextBox_();
    ret.setValue(inValue);
    return ret;
  }

  private ListBox_ listbox(String... inValue)
  {
    ListBox_ ret = new ListBox_();
    ret.setMultipleSelect(true);
    for (String value : inValue)
    {
      ret.add(value);
    }
    ret.getItems().get(1).setSelected(true);
    ret.getItems().get(2).setSelected(true);
    return ret;
  }

  private CheckBox_ checkbox(String inText, Boolean inValue)
  {
    CheckBox_ ret = new CheckBox_();
    ret.setText(inText);
    ret.setValue(inValue);
    return ret;
  }
}