package net.hus.core.shared.components;

import net.hus.core.shared.model.Components.Type;

public class Container_ extends ComplexWidget_
{
  private static final long serialVersionUID = -1227227051213839201L;

  private Boolean mFluid;

  @Override
  public Type cType()
  {
    return Type.CONTAINER;
  }

  public Boolean getFluid()
  {
    return mFluid;
  }

  public void setFluid(Boolean inFluid)
  {
    mFluid = inFluid;
  }
}