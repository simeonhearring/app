package net.hus.core.shared.command;

import net.hus.core.shared.model.Response;
import net.hus.core.shared.rpc.CommandName;
import net.hus.core.shared.rpc.HasCommandName;

@CommandName("RequestCommand")
public class RequestCommand extends AbstractDataCommand<Response> implements HasCommandName
{
  private static final long serialVersionUID = 8712567104547510128L;

  private String mCommandName;

  RequestCommand()
  {
  }

  public RequestCommand(String inCommandName)
  {
    mCommandName = inCommandName;
  }

  @Override
  public String commandName()
  {
    return mCommandName;
  }
}