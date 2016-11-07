package net.hus.core.shared.command;

import net.hus.core.shared.components.Response;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.rpc.CommandName;
import net.hus.core.shared.rpc.HasCommandName;

@CommandName("RequestCommand")
public class RequestCommand extends AbstractDataCommand<Response> implements HasCommandName
{
  private static final long serialVersionUID = 8712567104547510128L;

  private String mCommandName;
  private FieldTKG mFieldTKG;

  RequestCommand()
  {
  }

  public RequestCommand(String inCommandName, FieldTKG inFieldTKG)
  {
    mCommandName = inCommandName;
    mFieldTKG = inFieldTKG;
  }

  @Override
  public String commandName()
  {
    return mCommandName;
  }

  public FieldTKG tkg()
  {
    return mFieldTKG;
  }
}