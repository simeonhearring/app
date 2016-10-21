package net.hus.core.server.command;

import org.gwtbootstrap3.client.ui.constants.AlertType;

import net.hus.core.client.ui.Alert_;
import net.hus.core.client.ui.Badge_;
import net.hus.core.shared.command.UIObjectCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class UIObjectCommandBean extends AbstractCommandBean<UIObjectCommand<?>>
{
  @Override
  public RpcResponse execute(UIObjectCommand<?> inCommand)
  {
    Alert_ alert = new Alert_("Hello", AlertType.DANGER);

    Badge_ badge = new Badge_("Hello");

    inCommand.setData(badge);

    return inCommand;
  }
}