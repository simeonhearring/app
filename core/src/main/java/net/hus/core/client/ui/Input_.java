package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.constants.InputType;

public class Input_ extends ValueBoxBase_<String>
{
  private static final long serialVersionUID = -5284956640088592314L;

  private String mMin;
  private String mMax;
  private InputType mType;

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