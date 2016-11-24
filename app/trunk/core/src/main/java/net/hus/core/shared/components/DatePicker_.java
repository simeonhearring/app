package net.hus.core.shared.components;

import net.hus.core.shared.model.Components.Type;

public class DatePicker_ extends DatePickerBase_
{
  private static final long serialVersionUID = -824973313790709246L;

  @Override
  public Type cType()
  {
    return Type.DATE_PICKER;
  }
}