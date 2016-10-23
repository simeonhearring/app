package net.hus.core.server.command;

import net.hus.core.parser.Container_Parser;
import net.hus.core.shared.command.UIObjectCommand;
import net.hus.core.shared.model.Container_;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.ResourceUtil;

public class UIObjectCommandBean extends AbstractCommandBean<UIObjectCommand<?>>
{
  @Override
  public RpcResponse execute(UIObjectCommand<?> inCommand)
  {
    String xml = ResourceUtil.contents("net/hus/core/client/ui/Page.xml");

    Container_Parser parser = new Container_Parser();

    Container_ container = (Container_) parser.fromXml(xml);

    inCommand.setData(container);

    return inCommand;
  }
}