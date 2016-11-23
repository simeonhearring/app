package net.hus.core.shared.components;

import net.hus.core.shared.model.UIObject_;

public class Badge_ extends UIObject_
{
  private static final long serialVersionUID = -2146577562552529671L;

  private String mText;

  public Badge_()
  {
  }

  public Badge_(String inText)
  {
    mText = inText;
  }

  public String getText()
  {
    return mText;
  }

  public void setText(String inText)
  {
    mText = inText;
  }
}