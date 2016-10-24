package net.hus.core.shared.command;

import net.hus.core.shared.model.Components;
import net.hus.core.shared.rpc.CommandName;

@CommandName("UIObjectCommand")
public class UIObjectCommand extends AbstractDataCommand<Components>
{
  private static final long serialVersionUID = -2970113047435446656L;

  public Components getComponents()
  {
    return getData();
  }
}