package net.hus.core.shared.components;

import net.hus.core.shared.model.Components.Type;
import net.hus.core.shared.model.UIObject_;

public class FieldSet_ extends ComplexWidget_
{
  private static final long serialVersionUID = -7763876407937799191L;

  private boolean mEnabled = true;

  @Override
  public Type cType()
  {
    return Type.FIELD_SET;
  }

  @Override
  public boolean add(UIObject_ inUiObject)
  {
    if (inUiObject instanceof FormGroup_)
    {
      return super.add(inUiObject);
    }
    return false;
  }

  public boolean isEnabled()
  {
    return mEnabled;
  }

  public void setEnabled(boolean inEnabled)
  {
    mEnabled = inEnabled;
  }
}