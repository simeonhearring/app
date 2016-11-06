package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.LabelType;

public class Label_ extends AbstractTextWidget_
{
  private static final long serialVersionUID = 2171498172036699127L;

  private LabelType mLabelType;

  public LabelType getLabelType()
  {
    return mLabelType;
  }

  public void setLabelType(LabelType inLabelType)
  {
    mLabelType = inLabelType;
  }
}