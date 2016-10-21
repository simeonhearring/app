package net.hus.core.server.command;

import org.gwtbootstrap3.client.ui.constants.InputType;

import net.hus.core.client.ui.FieldSet_;
import net.hus.core.client.ui.FormGroup_;
import net.hus.core.client.ui.FormLabel_;
import net.hus.core.client.ui.Input_;
import net.hus.core.shared.command.UIObjectCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class UIObjectCommandBean extends AbstractCommandBean<UIObjectCommand<?>>
{
  @Override
  public RpcResponse execute(UIObjectCommand<?> inCommand)
  {
    FieldSet_ set = new FieldSet_();

    set.add(group("Field1:", "Hello"));
    set.add(group("Field2:", "World"));

    inCommand.setData(set);

    return inCommand;
  }

  private FormGroup_ group(String inLabel, String inValue)
  {
    FormGroup_ group = new FormGroup_();

    FormLabel_ label = new FormLabel_();
    label.setText(inLabel);
    group.add(label);

    Input_ input = new Input_();
    input.setValue(inValue);
    input.setType(InputType.TEXT);
    // input.setWidth("100px");
    group.add(input);
    return group;
  }
}