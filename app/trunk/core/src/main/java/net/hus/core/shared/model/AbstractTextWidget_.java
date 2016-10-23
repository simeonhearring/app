package net.hus.core.shared.model;

import org.gwtbootstrap3.client.ui.constants.Pull;

public class AbstractTextWidget_ extends UIObject_
{
  private static final long serialVersionUID = -2196387944056044191L;

  private String mText;
  private boolean mHtml;
  private String mColor;
  private Double mMarginBottom;
  private Double mMarginLeft;
  private Double mMarginRight;
  private Double mMarginTop;
  private Double mPaddingBottom;
  private Double mPaddingLeft;
  private Double mPaddingRight;
  private Double mPaddingTop;
  private Pull mPull;

  public String getColor()
  {
    return mColor;
  }

  public void setColor(String inColor)
  {
    mColor = inColor;
  }

  public Double getMarginBottom()
  {
    return mMarginBottom;
  }

  public void setMarginBottom(Double inMarginBottom)
  {
    mMarginBottom = inMarginBottom;
  }

  public Double getMarginLeft()
  {
    return mMarginLeft;
  }

  public void setMarginLeft(Double inMarginLeft)
  {
    mMarginLeft = inMarginLeft;
  }

  public Double getMarginRight()
  {
    return mMarginRight;
  }

  public void setMarginRight(Double inMarginRight)
  {
    mMarginRight = inMarginRight;
  }

  public Double getMarginTop()
  {
    return mMarginTop;
  }

  public void setMarginTop(Double inMarginTop)
  {
    mMarginTop = inMarginTop;
  }

  public Double getPaddingBottom()
  {
    return mPaddingBottom;
  }

  public void setPaddingBottom(Double inPaddingBottom)
  {
    mPaddingBottom = inPaddingBottom;
  }

  public Double getPaddingLeft()
  {
    return mPaddingLeft;
  }

  public void setPaddingLeft(Double inPaddingLeft)
  {
    mPaddingLeft = inPaddingLeft;
  }

  public Double getPaddingRight()
  {
    return mPaddingRight;
  }

  public void setPaddingRight(Double inPaddingRight)
  {
    mPaddingRight = inPaddingRight;
  }

  public Double getPaddingTop()
  {
    return mPaddingTop;
  }

  public void setPaddingTop(Double inPaddingTop)
  {
    mPaddingTop = inPaddingTop;
  }

  public Pull getPull()
  {
    return mPull;
  }

  public void setPull(Pull inPull)
  {
    mPull = inPull;
  }

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