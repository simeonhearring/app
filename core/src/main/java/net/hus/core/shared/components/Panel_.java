package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.PanelType;

public class Panel_ extends ComplexWidget_
{
  private static final long serialVersionUID = 8558694859904920002L;

  private PanelType mType;

  public PanelType getType()
  {
    return mType;
  }

  public void setType(PanelType inType)
  {
    mType = inType;
  }
}