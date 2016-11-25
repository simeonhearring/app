package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.Alignment;
import org.gwtbootstrap3.client.ui.constants.Emphasis;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;

import net.hus.core.shared.model.Components.Type;

public class Heading_ extends ComplexWidget_
{
  private static final long serialVersionUID = 7843526312913858982L;

  private HeadingSize mSize;
  private Emphasis mEmphasis;
  private Alignment mAlignment;
  private String mText;
  private String mSubText;

  @Override
  public Type cType()
  {
    return Type.HEADING;
  }

  public HeadingSize getSize()
  {
    return mSize;
  }

  public void setSize(HeadingSize inSize)
  {
    mSize = inSize;
  }

  public String getText()
  {
    return mText;
  }

  public void setText(String inText)
  {
    mText = inText;
  }

  public String getSubText()
  {
    return mSubText;
  }

  public void setSubText(String inSubText)
  {
    mSubText = inSubText;
  }

  public Emphasis getEmphasis()
  {
    return mEmphasis;
  }

  public void setEmphasis(Emphasis inEmphasis)
  {
    mEmphasis = inEmphasis;
  }

  public Alignment getAlignment()
  {
    return mAlignment;
  }

  public void setAlignment(Alignment inAlignment)
  {
    mAlignment = inAlignment;
  }
}