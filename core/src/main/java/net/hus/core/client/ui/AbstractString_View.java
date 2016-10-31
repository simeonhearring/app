package net.hus.core.client.ui;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Component;
import net.hus.core.model.TableKey;

public abstract class AbstractString_View<C extends Widget> implements Component<String>
{
  protected C mComponent;

  public AbstractString_View(C inComponent)
  {
    mComponent = inComponent;
  }

  @Override
  public void setFieldName(String inName)
  {
  }

  @Override
  public void setTableKey(TableKey inTableKey)
  {
  }

  @Override
  public Widget asWidget()
  {
    return mComponent;
  }
}