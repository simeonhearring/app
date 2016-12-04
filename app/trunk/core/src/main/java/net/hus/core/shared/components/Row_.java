package net.hus.core.shared.components;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.shared.model.Components.Type;
import net.hus.core.shared.model.HasColumn;
import net.hus.core.shared.model.UIObject_;

public class Row_ extends ComplexWidget_ implements HasColumn<Column_>
{
  private static final long serialVersionUID = -5539999096086413794L;

  private List<Column_> mColumn;

  @Override
  public Type cType()
  {
    return Type.ROW;
  }

  @Override
  public boolean add(UIObject_ inUiObject)
  {
    if (inUiObject instanceof Column_)
    {
      add((Column_) inUiObject);
      return true;
    }
    return false;
  }

  private void add(Column_ inUiObject)
  {
    if (mColumn == null)
    {
      mColumn = new ArrayList<>();
    }
    mColumn.add(inUiObject);
  }

  @Override
  public List<Column_> getColumn()
  {
    return mColumn;
  }

  public void setColumn(List<Column_> inColumn)
  {
    mColumn = inColumn;
  }
}