package net.hus.core.shared.command;

import net.hus.core.shared.model.Components;
import net.hus.core.shared.rpc.CommandName;

@CommandName("ComponentsCommand")
public class ComponentsCommand extends AbstractDataCommand<Components>
{
  private static final long serialVersionUID = -2970113047435446656L;

  private String mComponentsName;
  private String mFvk;

  ComponentsCommand()
  {
  }

  public ComponentsCommand(String inComponentsName, String inFvk)
  {
    mComponentsName = inComponentsName;
    mFvk = inFvk;
  }

  public Components getComponents()
  {
    return getData();
  }

  public String getComponentsName()
  {
    return mComponentsName;
  }

  public String fvk()
  {
    return mFvk;
  }
}