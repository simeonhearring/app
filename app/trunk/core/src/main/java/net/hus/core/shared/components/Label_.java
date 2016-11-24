package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.LabelType;

import net.hus.core.shared.model.Components.Type;

public class Label_ extends AbstractTextWidget_
{
  private static final long serialVersionUID = 2171498172036699127L;

  private LabelType mLabelType;

  @Override
  public Type cType()
  {
    return Type.LABEL;
  }

  public LabelType getLabelType()
  {
    return mLabelType;
  }

  public void setLabelType(LabelType inLabelType)
  {
    mLabelType = inLabelType;
  }
}