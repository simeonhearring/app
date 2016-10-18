package net.hus.core.server.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import net.hus.core.shared.command.LoggerCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class LoggerCommandBean extends AbstractCommandBean<LoggerCommand>
{
  private static final Logger LOGGER = Logger.getLogger(LoggerCommandBean.class);

  @Override
  public RpcResponse execute(LoggerCommand inCommand)
  {
    try
    {
      LOGGER.log(convert(inCommand.getLevel()), inCommand.getMessage(), inCommand.getThrowable());
    }
    catch (Exception e)
    {
      LOGGER.error("Error Logging " + inCommand.getMessage(), e);
    }
    return inCommand;
  }

  private static Level convert(LoggerCommand.Level inLevel)
  {
    return Level.toLevel(inLevel.name(), Level.DEBUG);
  }
}
