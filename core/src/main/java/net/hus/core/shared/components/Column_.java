package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.ColumnOffset;
import org.gwtbootstrap3.client.ui.constants.ColumnPull;
import org.gwtbootstrap3.client.ui.constants.ColumnPush;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;

import net.hus.core.shared.model.Components.Type;

public class Column_ extends ComplexWidget_
{
  private static final long serialVersionUID = 3982209812933977662L;

  private ColumnSize mSize;
  private ColumnSize[] mOtherSize;
  private ColumnPull[] mPull;
  private ColumnPush[] mPush;
  private ColumnOffset[] mOffset;

  @Override
  public Type cType()
  {
    return Type.COLUMN;
  }

  public void addSize(ColumnSize... inSize)
  {
    mOtherSize = inSize;
  }

  public void addPull(ColumnPull... inPull)
  {
    mPull = inPull;
  }

  public void addPush(ColumnPush... inPush)
  {
    mPush = inPush;
  }

  public void addOffset(ColumnOffset... inOffset)
  {
    mOffset = inOffset;
  }

  public void setSize(ColumnSize inSize)
  {
    mSize = inSize;
  }

  public ColumnSize getSize()
  {
    return mSize;
  }

  public ColumnSize[] getOtherSize()
  {
    return mOtherSize;
  }

  public ColumnPull[] getPulls()
  {
    return mPull;
  }

  public ColumnPush[] getPush()
  {
    return mPush;
  }

  public ColumnOffset[] getOffset()
  {
    return mOffset;
  }
}