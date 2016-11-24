package net.hus.core.shared.components;

import net.hus.core.shared.model.Components.Type;

public class CheckBox_ extends ButtonBase_
{
  private static final long serialVersionUID = 1779508002760278396L;

  private Boolean mValue;

  @Override
  public Type cType()
  {
    return Type.CHECK_BOX;
  }

  public Boolean getValue()
  {
    return mValue;
  }

  public void setValue(Boolean inValue)
  {
    mValue = inValue;
  }
}