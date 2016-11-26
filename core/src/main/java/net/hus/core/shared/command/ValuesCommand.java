package net.hus.core.shared.command;

import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Values;
import net.hus.core.shared.rpc.CommandName;

@CommandName("ValuesCommand")
public class ValuesCommand extends AbstractDataCommand<Values>
{
  private static final long serialVersionUID = -6479050202051212707L;

  private FieldTKG mTKG;

  ValuesCommand()
  {
  }

  public ValuesCommand(FieldTKG inTKG)
  {
    mTKG = inTKG;
  }

  public Values getValues()
  {
    return getData();
  }

  public FieldTKG getTKG()
  {
    return mTKG;
  }
}