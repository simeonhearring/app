package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.Emphasis;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;

import net.hus.core.shared.model.Components.Type;

public class Icon_ extends ComplexWidget_
{
  private static final long serialVersionUID = -7178558740092056147L;

  private IconType mType;
  private IconSize mSize;
  private IconRotate mRotate;
  private IconFlip mFlip;
  private Emphasis mEmphasis;
  private Boolean mBorder, mSpin, mPulse, mInverse, mStackTop, mStackBase, mFixedWidth;

  @Override
  public Type cType()
  {
    return Type.ICON;
  }

  public IconType getType()
  {
    return mType;
  }

  public void setType(IconType inType)
  {
    mType = inType;
  }

  public IconSize getSize()
  {
    return mSize;
  }

  public void setSize(IconSize inSize)
  {
    mSize = inSize;
  }

  public IconRotate getRotate()
  {
    return mRotate;
  }

  public void setRotate(IconRotate inRotate)
  {
    mRotate = inRotate;
  }

  public IconFlip getFlip()
  {
    return mFlip;
  }

  public void setFlip(IconFlip inFlip)
  {
    mFlip = inFlip;
  }

  public Emphasis getEmphasis()
  {
    return mEmphasis;
  }

  public void setEmphasis(Emphasis inEmphasis)
  {
    mEmphasis = inEmphasis;
  }

  public Boolean getBorder()
  {
    return mBorder;
  }

  public void setBorder(Boolean inBorder)
  {
    mBorder = inBorder;
  }

  public Boolean getSpin()
  {
    return mSpin;
  }

  public void setSpin(Boolean inSpin)
  {
    mSpin = inSpin;
  }

  public Boolean getPulse()
  {
    return mPulse;
  }

  public void setPulse(Boolean inPulse)
  {
    mPulse = inPulse;
  }

  public Boolean getInverse()
  {
    return mInverse;
  }

  public void setInverse(Boolean inInverse)
  {
    mInverse = inInverse;
  }

  public Boolean getStackTop()
  {
    return mStackTop;
  }

  public void setStackTop(Boolean inStackTop)
  {
    mStackTop = inStackTop;
  }

  public Boolean getStackBase()
  {
    return mStackBase;
  }

  public void setStackBase(Boolean inStackBase)
  {
    mStackBase = inStackBase;
  }

  public Boolean getFixedWidth()
  {
    return mFixedWidth;
  }

  public void setFixedWidth(Boolean inFixedWidth)
  {
    mFixedWidth = inFixedWidth;
  }
}