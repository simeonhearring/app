package net.hus.core.server.command;

import net.hus.core.parser.ComponentsParser;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.ResourceUtil;

public class ComponentsCommandBean extends AbstractCommandBean<ComponentsCommand>
{
  @Override
  public RpcResponse execute(ComponentsCommand inCommand)
  {
    String xml = ResourceUtil.contents("net/hus/core/client/ui/Page.xml");

    ComponentsParser parser = new ComponentsParser();

    Components container = parser.fromXml(xml);

    container.setValues(mCoreDao.values().selectLast("JUNIT"));

    inCommand.setData(container);

    return inCommand;
  }
}