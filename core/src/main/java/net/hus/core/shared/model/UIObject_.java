package net.hus.core.shared.model;

import java.io.Serializable;

public class UIObject_ implements Serializable
{
  private static final long serialVersionUID = 4099428684832729483L;

  private String mKey;

  private String mId;
  private Boolean mVisible;
  private String mHeight;
  private String mWidth;
  private String mTitle;
  private String mStyleName;
  private String mStylePrimaryName;

  public String getHeight()
  {
    return mHeight;
  }

  public String getWidth()
  {
    return mWidth;
  }

  public String getStyleName()
  {
    return mStyleName;
  }

  public String getStylePrimaryName()
  {
    return mStylePrimaryName;
  }

  public Boolean getVisible()
  {
    return mVisible;
  }

  public String getTitle()
  {
    return mTitle;
  }

  public void setHeight(String inHeight)
  {
    mHeight = inHeight;
  }

  public void setPixelSize(int inWidth, int inHeight)
  {
    mWidth = inWidth + "px";
    mHeight = inHeight + "px";
  }

  public void setSize(String inWidth, String inHeight)
  {
    mWidth = inWidth;
    mHeight = inHeight;
  }

  public void setStyleDependentName(String inStyleSuffix, boolean inAdd)
  {
  }

  public void setStyleName(String inStyle)
  {
    mStyleName = inStyle;
  }

  public void setStyleName(String inStyle, boolean inAdd)
  {
  }

  public void setStylePrimaryName(String inStyle)
  {
    mStylePrimaryName = inStyle;
  }

  public void setTitle(String inTitle)
  {
    mTitle = inTitle;
  }

  public void setVisible(Boolean inVisible)
  {
    mVisible = inVisible;
  }

  public void setWidth(String inWidth)
  {
    mWidth = inWidth;
  }

  public String getId()
  {
    return mId;
  }

  public void setId(String inId)
  {
    mId = inId;
  }

  public String getKey()
  {
    return mKey;
  }

  public void setKey(String inKey)
  {
    mKey = inKey;
  }
}