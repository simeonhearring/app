package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.PanelType;

import net.hus.core.shared.model.Components.Type;

public class Panel_ extends ComplexWidget_
{
  private static final long serialVersionUID = 8558694859904920002L;

  private PanelType mType;

  @Override
  public Type cType()
  {
    return Type.PANEL;
  }

  public PanelType getType()
  {
    return mType;
  }

  public void setType(PanelType inType)
  {
    mType = inType;
  }
}