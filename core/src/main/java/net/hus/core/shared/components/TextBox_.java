package net.hus.core.shared.components;

import net.hus.core.shared.model.Components.Type;

public class TextBox_ extends ValueBoxBase_
{
  private static final long serialVersionUID = -7421425106740416787L;

  private String mValue;

  @Override
  public Type cType()
  {
    return Type.TEXT_BOX;
  }

  public String getValue()
  {
    return mValue;
  }

  public void setValue(String inValue)
  {
    mValue = inValue;
  }
}