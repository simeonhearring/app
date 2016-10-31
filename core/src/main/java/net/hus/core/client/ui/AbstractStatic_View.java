package net.hus.core.client.ui;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Component;
import net.hus.core.model.TableFvk;

public abstract class AbstractStatic_View<C extends Widget> implements Component<String>
{
  protected C mComponent;

  public AbstractStatic_View(C inComponent)
  {
    mComponent = inComponent;
  }

  @Override
  public void setLabel(String inName)
  {
  }

  @Override
  public void setTableKey(TableFvk inTableKey)
  {
  }

  @Override
  public final Widget asWidget()
  {
    return mComponent;
  }
}