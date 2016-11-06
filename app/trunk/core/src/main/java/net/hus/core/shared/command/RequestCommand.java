package net.hus.core.shared.command;

import net.hus.core.model.FieldTKG;
import net.hus.core.shared.model.Response;
import net.hus.core.shared.rpc.CommandName;
import net.hus.core.shared.rpc.HasCommandName;

@CommandName("RequestCommand")
public class RequestCommand extends AbstractDataCommand<Response> implements HasCommandName
{
  private static final long serialVersionUID = 8712567104547510128L;

  private String mCommandName;
  private FieldTKG mFvk;

  RequestCommand()
  {
  }

  public RequestCommand(String inCommandName)
  {
    mCommandName = inCommandName;
  }

  public RequestCommand(String inCommandName, FieldTKG inFvk)
  {
    mCommandName = inCommandName;
    mFvk = inFvk;
  }

  @Override
  public String commandName()
  {
    return mCommandName;
  }

  public FieldTKG fvk()
  {
    return mFvk;
  }
}