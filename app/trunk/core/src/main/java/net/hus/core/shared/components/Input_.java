package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.InputType;

import net.hus.core.shared.model.Components.Type;

public class Input_ extends ValueBoxBase_
{
  private static final long serialVersionUID = -5284956640088592314L;

  private String mMin;
  private String mMax;
  private InputType mType;
  private String mValue;

  public Input_()
  {
    mType = InputType.TEXT;
  }

  public Input_(InputType inType)
  {
    mType = inType;
  }

  @Override
  public Type cType()
  {
    return Type.INPUT;
  }

  public String getValue()
  {
    return mValue;
  }

  public void setValue(String inValue)
  {
    mValue = inValue;
  }

  public String getMin()
  {
    return mMin;
  }
  public void setMin(String inMin)
  {
    mMin = inMin;
  }

  public String getMax()
  {
    return mMax;
  }

  public void setMax(String inMax)
  {
    mMax = inMax;
  }

  public InputType getType()
  {
    return mType;
  }

  public void setType(InputType inType)
  {
    mType = inType;
  }
}