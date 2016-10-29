package net.hus.core.shared.command;

import net.hus.core.shared.model.Components;
import net.hus.core.shared.rpc.CommandName;

@CommandName("ComponentsCommand")
public class ComponentsCommand extends AbstractDataCommand<Components>
{
  private static final long serialVersionUID = -2970113047435446656L;

  private String mPage;
  private String mKey;

  ComponentsCommand()
  {
  }

  public ComponentsCommand(String inPage, String inKey)
  {
    mPage = inPage;
    mKey = inKey;
  }

  public Components getComponents()
  {
    return getData();
  }

  public String getPage()
  {
    return mPage;
  }

  public String getKey()
  {
    return mKey;
  }
}