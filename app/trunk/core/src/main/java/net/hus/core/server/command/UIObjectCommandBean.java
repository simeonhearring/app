package net.hus.core.server.command;

import net.hus.core.client.ui.Container_;
import net.hus.core.parser.ContainerParser;
import net.hus.core.shared.command.UIObjectCommand;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.ResourceUtil;

public class UIObjectCommandBean extends AbstractCommandBean<UIObjectCommand<?>>
{
  @Override
  public RpcResponse execute(UIObjectCommand<?> inCommand)
  {
    String xml = ResourceUtil.contents("net/hus/core/client/ui/Page.xml");

    ContainerParser parser = new ContainerParser();

    Container_ container = (Container_) parser.fromXml(xml);

    inCommand.setData(container);

    return inCommand;
  }
}