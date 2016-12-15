package net.hus.core.shared.components;

import net.hus.core.shared.model.Components.Type;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.UIObject_;

public class FlexTable_ extends UIObject_
{
  private static final long serialVersionUID = -4918962966365747922L;

  private Field.Array mArray;

  @Override
  public Type cType()
  {
    return Type.FLEX_TABLE;
  }

  public Field.Array getArray()
  {
    return mArray;
  }

  public void setArray(Field.Array inArray)
  {
    mArray = inArray;
  }
}