package net.hus.core.shared.components;

import java.util.List;

import net.hus.core.shared.model.Components.Type;

public class Row_ extends ComplexWidget_
{
  private static final long serialVersionUID = -5539999096086413794L;

  private List<Column_> mColumn;

  @Override
  public Type cType()
  {
    return Type.ROW;
  }

  public List<Column_> getColumn()
  {
    return mColumn;
  }

  public void setColumn(List<Column_> inColumn)
  {
    mColumn = inColumn;
  }
}