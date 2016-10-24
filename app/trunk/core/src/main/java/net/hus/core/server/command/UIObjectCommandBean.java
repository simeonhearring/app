package net.hus.core.server.command;

import net.hus.core.parser.ComponentsParser;
import net.hus.core.shared.command.UIObjectCommand;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.ResourceUtil;

public class UIObjectCommandBean extends AbstractCommandBean<UIObjectCommand>
{
  @Override
  public RpcResponse execute(UIObjectCommand inCommand)
  {
    String xml = ResourceUtil.contents("net/hus/core/client/ui/Page.xml");

    ComponentsParser parser = new ComponentsParser();

    Components container = parser.fromXml(xml);

    inCommand.setData(container);

    return inCommand;
  }
}