package net.hus.core.server.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.hus.core.parser.Table_Parser;
import net.hus.core.shared.command.ValuesCommand;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;
import net.hus.core.shared.model.Values;
import net.hus.core.shared.rpc.common.RpcResponse;

public class ValuesCommandBean extends AbstractCommandBean<ValuesCommand>
{
  private Table_Parser mParser;

  public ValuesCommandBean()
  {
    mParser = new Table_Parser();
  }

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
    return checkForArrays(mCoreDao.values().selectLastPos(inFieldTKG));
  }

  protected List<Value> checkForArrays(List<Value> inList)
  {
    Map<Long, Value> tables = new HashMap<>();

    for (Value value : inList)
    {
      if (value.getField().isTable())
      {
        if (!tables.containsKey(value.getFid()))
        {
          value.setValues(new Values(value.getField(), new ArrayList<Value>()));
          tables.put(value.getFid(), value);
        }
      }
      else if (value.getField().isArray() && value.getValue() != null)
      {
        value.setTable(mParser.fromXml(value.getValue()));
      }
    }

    List<Value> ret = new ArrayList<>();

    for (Value value : inList)
    {
      boolean add = true;
      for (Entry<Long, Value> table : tables.entrySet())
      {
        if (table.getValue().getField().isPartOfTable(value.getFid()))
        {
          add = false;
          table.getValue().getValues().add(value);
        }
      }
      if (add)
      {
        ret.add(value);
      }
    }

    return ret;
  }
}