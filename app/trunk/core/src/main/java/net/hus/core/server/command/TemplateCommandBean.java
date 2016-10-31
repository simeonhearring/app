package net.hus.core.server.command;

import net.hus.core.model.Page;
import net.hus.core.parser.PageParser;
import net.hus.core.shared.command.TemplateCommand;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.ResourceUtil;

public class TemplateCommandBean extends AbstractCommandBean<TemplateCommand>
{
  @Override
  public RpcResponse execute(TemplateCommand inCommand)
  {
    String xml = ResourceUtil.contents("Page.xml");

    PageParser parser = new PageParser();

    Page template = parser.fromXml(xml);

    inCommand.setData(template);

    return inCommand;
  }
}