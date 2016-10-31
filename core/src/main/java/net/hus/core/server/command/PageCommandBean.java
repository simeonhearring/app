package net.hus.core.server.command;

import net.hus.core.model.Page;
import net.hus.core.parser.PageParser;
import net.hus.core.shared.command.PageCommand;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.ResourceUtil;

public class PageCommandBean extends AbstractCommandBean<PageCommand>
{
  @Override
  public RpcResponse execute(PageCommand inCommand)
  {
    String xml = ResourceUtil.contents("Page.xml");

    PageParser parser = new PageParser();

    Page template = parser.fromXml(xml);

    inCommand.setData(template);

    return inCommand;
  }
}