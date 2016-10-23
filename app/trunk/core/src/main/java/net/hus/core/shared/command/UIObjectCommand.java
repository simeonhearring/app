package net.hus.core.shared.command;

import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.rpc.CommandName;

@CommandName("UIObjectCommand")
public class UIObjectCommand<T extends UIObject_> extends AbstractDataCommand<UIObject_>
{
  private static final long serialVersionUID = -2970113047435446656L;

  @SuppressWarnings("unchecked")
  public T getUIObject()
  {
    return (T) getData();
  }
}