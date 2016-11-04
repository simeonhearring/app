package net.hus.core.server.command;

import java.util.List;

import net.hus.core.model.Field;
import net.hus.core.model.Lookup;
import net.hus.core.model.TableFvk;
import net.hus.core.model.Value;
import net.hus.core.parser.Table_Parser;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.ListBox_;
import net.hus.core.shared.rpc.common.RpcResponse;

public class ComponentsCommandBean extends AbstractCommandBean<ComponentsCommand>
{
  @Override
  public RpcResponse execute(ComponentsCommand inCommand)
  {
    Components components = mCoreDao.components(inCommand.getComponentName());

    addLookups(components);

    addValues(components, inCommand.fvk());

    inCommand.setData(components);

    return inCommand;
  }

  private void addValues(Components inComponents, String inFvk)
  {
    TableFvk tableKey = inComponents.getTableFvk();
    tableKey.setFvk(inFvk);
    inComponents.setValues(checkForArrays(mCoreDao.values().selectLast(tableKey)));
  }

  private void addLookups(Components inComponents)
  {
    for (ListBox_ value : inComponents.getListBoxes())
    {
      if (Field.Lookup.Location.TABLE.equals(value.getLookup().getLocation()))
      {
        value.clearItems();
        for (String group : value.getLookup().getParameters().split(","))
        {
          for (Lookup lookup : mCoreDao.lookups().select(group))
          {
            value.add(lookup.getName(), lookup.getId().toString());
          }
        }
      }
    }
  }

  private List<Value> checkForArrays(List<Value> inOut)
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