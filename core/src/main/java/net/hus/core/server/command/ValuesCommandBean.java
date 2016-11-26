package net.hus.core.server.command;

import java.util.List;

import net.hus.core.parser.Table_Parser;
import net.hus.core.shared.command.ValuesCommand;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;
import net.hus.core.shared.model.Values;
import net.hus.core.shared.rpc.common.RpcResponse;

public class ValuesCommandBean extends AbstractCommandBean<ValuesCommand>
{
  @Override
  public RpcResponse execute(ValuesCommand inCommand)
  {
    Values data = new Values();

    data.setValues(getValues(inCommand.getTKG()));

    inCommand.setData(data);

    return inCommand;
  }

  protected List<Value> getValues(FieldTKG inFieldTKG)
  {
    return checkForArrays(mCoreDao.values().selectLast(inFieldTKG));
  }

  private static List<Value> checkForArrays(List<Value> inOut)
  {
    Table_Parser parser = new Table_Parser();
    for (Value value : inOut)
    {
      if (value.getField().isArray() && value.getValue() != null)
      {
        value.setTable(parser.fromXml(value.getValue()));
      }
    }
    return inOut;
  }
}