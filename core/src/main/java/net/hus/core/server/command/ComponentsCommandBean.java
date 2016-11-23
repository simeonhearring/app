package net.hus.core.server.command;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.parser.Table_Parser;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.components.ComplexPanel_;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.LookupOptions;
import net.hus.core.shared.model.UIObject_;
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
    inComponents.setValues(getValues(fieldTKG, inFvk));
  }

  private void addLookups(Components inComponents)
  {
    for (LookupOptions value : getLookupOptions(inComponents.getList()))
    {
      if (Field.Lookup.Location.TABLE.equals(value.getLocation()))
      {
        value.init();
        for (String group : value.getLookupGroups())
        {
          for (Lookup lookup : mCoreDao.lookups().select(group))
          {
            value.add(lookup);
          }
        }
      }
    }
  }

  private List<LookupOptions> getLookupOptions(List<UIObject_> inList)
  {
    List<LookupOptions> ret = new ArrayList<>();
    find(ret, inList);
    return ret;
  }

  private static void find(List<LookupOptions> inAddTo, List<UIObject_> inSearchingIn)
  {
    if (inSearchingIn != null)
    {
      for (UIObject_ value : inSearchingIn)
      {
        if (value instanceof ComplexPanel_)
        {
          find(inAddTo, ((ComplexPanel_) value).getCollection());
        }
        else if (value instanceof LookupOptions)
        {
          inAddTo.add((LookupOptions) value);
        }
      }
    }
  }

  private List<Value> getValues(FieldTKG inFieldTKG, String inFvk)
  {
    inFieldTKG.setFvk(inFvk);
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