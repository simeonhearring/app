package net.hus.core.client.ui.common;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.View;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;

public abstract class AbstractStatic_View<C extends Widget> implements View
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
  public void addChangeHandler()
  {
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

  @Override
  public void setPos(int inPos)
  {
  }
}