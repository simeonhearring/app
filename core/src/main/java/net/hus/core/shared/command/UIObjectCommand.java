package net.hus.core.shared.command;

import net.hus.core.client.ui.UIObject_;
import net.hus.core.shared.rpc.CommandName;

@SuppressWarnings("serial")
@CommandName("UIObjectCommand")
public class UIObjectCommand<T extends UIObject_> extends AbstractDataCommand<UIObject_>
{
  @SuppressWarnings("unchecked")
  public T getUIObject()
  {
    return (T) getData();
  }
}