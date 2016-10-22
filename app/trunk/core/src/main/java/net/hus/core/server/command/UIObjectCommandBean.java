package net.hus.core.server.command;

import net.hus.core.client.ui.FieldSet_;
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

    inCommand.setData(set);

    return inCommand;
  }
}