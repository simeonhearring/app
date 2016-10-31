package net.hus.core.server.command;

import net.hus.core.model.Template;
import net.hus.core.parser.TemplateParser;
import net.hus.core.shared.command.TemplateCommand;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.ResourceUtil;

public class TemplateCommandBean extends AbstractCommandBean<TemplateCommand>
{
  @Override
  public RpcResponse execute(TemplateCommand inCommand)
  {
    String xml = ResourceUtil.contents("PageDisplay.xml");

    TemplateParser parser = new TemplateParser();

    Template template = parser.fromXml(xml);

    inCommand.setData(template);

    return inCommand;
  }
}