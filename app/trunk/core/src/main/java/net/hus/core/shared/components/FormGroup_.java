package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.FormGroupSize;
import org.gwtbootstrap3.client.ui.constants.ValidationState;

public class FormGroup_ extends ComplexPanel_
{
  private static final long serialVersionUID = -6876941845855998620L;

  private FormGroupSize mSize;
  private ValidationState mState;

  public FormGroupSize getSize()
  {
    return mSize;
  }

  public void setSize(FormGroupSize inSize)
  {
    mSize = inSize;
  }

  public ValidationState getState()
  {
    return mState;
  }

  public void setState(ValidationState inState)
  {
    mState = inState;
  }
}