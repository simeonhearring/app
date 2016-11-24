package net.hus.core.shared.components;

import net.hus.core.shared.model.Components.Type;

public class FieldSet_ extends ComplexWidget_
{
  private static final long serialVersionUID = -7763876407937799191L;

  private boolean mEnabled = true;

  @Override
  public Type cType()
  {
    return Type.FIELD_SET;
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