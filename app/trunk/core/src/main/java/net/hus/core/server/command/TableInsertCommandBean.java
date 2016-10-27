package net.hus.core.server.command;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.model.Value;
import net.hus.core.parser.Table_Parser;
import net.hus.core.shared.command.TableInsertCommand;
import net.hus.core.shared.rpc.common.RpcResponse;

public class TableInsertCommandBean extends AbstractCommandBean<TableInsertCommand>
{
  @Override
  public RpcResponse execute(TableInsertCommand inCommand)
  {
    Value value = inCommand.getValue();
    value.setValue(new Table_Parser().toXml(value.getTable()));

    List<Value> list = new ArrayList<>();
    list.add(value);

    mCoreDao.values().insert(list);
    return inCommand;
  }
}