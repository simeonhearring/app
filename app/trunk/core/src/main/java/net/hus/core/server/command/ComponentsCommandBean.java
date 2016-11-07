package net.hus.core.server.command;

import java.util.List;

import net.hus.core.parser.Table_Parser;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.components.Components;
import net.hus.core.shared.components.ListBox_;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Value;
import net.hus.core.shared.rpc.common.RpcResponse;

public class ComponentsCommandBean extends AbstractCommandBean<ComponentsCommand>
{
  @Override
  public RpcResponse execute(ComponentsCommand inCommand)
  {
    Components components = mCoreDao.components(inCommand.getComponentsName());

    addLookups(components);

    addValues(components, inCommand.fvk());

    inCommand.setData(components);

    return inCommand;
  }

  private void addValues(Components inComponents, String inFvk)
  {
    FieldTKG fieldTKG = inComponents.getFieldTKG();
    fieldTKG.setFvk(inFvk);
    inComponents.setValues(checkForArrays(mCoreDao.values().selectLast(fieldTKG)));
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