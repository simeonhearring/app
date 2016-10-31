package net.hus.core.shared.command;

import net.hus.core.shared.model.Components;
import net.hus.core.shared.rpc.CommandName;

@CommandName("ComponentsCommand")
public class ComponentsCommand extends AbstractDataCommand<Components>
{
  private static final long serialVersionUID = -2970113047435446656L;

  private String mComponentName;
  private String mFvk;

  ComponentsCommand()
  {
  }

  public ComponentsCommand(String inComponentName, String inFvk)
  {
    mComponentName = inComponentName;
    mFvk = inFvk;
  }

  public Components getComponents()
  {
    return getData();
  }

  public String getComponentName()
  {
    return mComponentName;
  }

  public String fvk()
  {
    return mFvk;
  }
}