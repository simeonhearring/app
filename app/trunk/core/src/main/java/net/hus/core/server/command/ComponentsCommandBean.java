package net.hus.core.server.command;

import net.hus.core.model.Field;
import net.hus.core.model.Lookup;
import net.hus.core.parser.ComponentsParser;
import net.hus.core.shared.command.ComponentsCommand;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.ListBox_;
import net.hus.core.shared.rpc.common.RpcResponse;
import net.hus.core.util.ResourceUtil;

public class ComponentsCommandBean extends AbstractCommandBean<ComponentsCommand>
{
  @Override
  public RpcResponse execute(ComponentsCommand inCommand)
  {
    String xml = ResourceUtil.contents("Page.xml");

    ComponentsParser parser = new ComponentsParser();

    Components container = parser.fromXml(xml);

    for (ListBox_ value : container.getListBoxes())
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

    container.setValues(mCoreDao.values().selectLast("JUNIT")); // TODO

    inCommand.setData(container);

    return inCommand;
  }
}