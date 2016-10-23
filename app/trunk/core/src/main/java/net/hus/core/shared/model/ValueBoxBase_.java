package net.hus.core.shared.model;

import org.gwtbootstrap3.client.ui.constants.InputSize;

public class ValueBoxBase_ extends FocusWidget_
{
  private static final long serialVersionUID = -8953529567451561818L;

  private Boolean mAllowBlank;
  private Boolean mAutoComplete;
  private Integer mMaxLength;
  private String mPlaceholder;
  private InputSize mSize;

  public Boolean getAllowBlank()
  {
    return mAllowBlank;
  }

  public void setAllowBlank(Boolean inAllowBlank)
  {
    mAllowBlank = inAllowBlank;
  }

  public Boolean getAutoComplete()
  {
    return mAutoComplete;
  }

  public void setAutoComplete(Boolean inAutoComplete)
  {
    mAutoComplete = inAutoComplete;
  }

  public Integer getMaxLength()
  {
    return mMaxLength;
  }

  public void setMaxLength(Integer inMaxLength)
  {
    mMaxLength = inMaxLength;
  }

  public String getPlaceholder()
  {
    return mPlaceholder;
  }

  public void setPlaceholder(String inPlaceholder)
  {
    mPlaceholder = inPlaceholder;
  }

  public InputSize getSize()
  {
    return mSize;
  }

  public void setSize(InputSize inSize)
  {
    mSize = inSize;
  }
}