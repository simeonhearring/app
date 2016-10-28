package net.hus.core.shared.command;

import net.hus.core.model.TableKey;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.rpc.CommandName;

@CommandName("ComponentsCommand")
public class ComponentsCommand extends AbstractDataCommand<Components>
{
  private static final long serialVersionUID = -2970113047435446656L;

  private TableKey mTableKey;

  public ComponentsCommand()
  {
  }

  public ComponentsCommand(TableKey inTableKey)
  {
    mTableKey = inTableKey;
  }

  public Components getComponents()
  {
    return getData();
  }

  public TableKey getTableKey()
  {
    return mTableKey;
  }
}