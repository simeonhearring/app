package net.hus.core.shared.model;

public class ButtonBase_ extends FocusWidget_
{
  private static final long serialVersionUID = 5671128013752424777L;

  private String mText;
  private boolean mHtml;

  public String getText()
  {
    return mText;
  }

  public void setText(String inText)
  {
    mHtml = false;
    mText = inText;
  }

  public void setHTML(String inText)
  {
    mHtml = true;
    mText = inText;
  }

  public boolean isHtml()
  {
    return mHtml;
  }

  public void setHtml(boolean inHtml)
  {
    mHtml = inHtml;
  }
}