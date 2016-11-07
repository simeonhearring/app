package net.hus.core.client.ui.components;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Component;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;

public abstract class AbstractStatic_View<C extends Widget> implements Component<String>
{
  protected C mComponent;

  public AbstractStatic_View(C inComponent)
  {
    mComponent = inComponent;
  }

  @Override
  public C getComponent()
  {
    return mComponent;
  }

  @Override
  public void setLabel(String inName)
  {
  }

  @Override
  public void setFieldTKG(FieldTKG inFTKG)
  {
  }

  @Override
  public void setField(Field inField)
  {
  }

  @Override
  public final Widget asWidget()
  {
    return mComponent;
  }
}