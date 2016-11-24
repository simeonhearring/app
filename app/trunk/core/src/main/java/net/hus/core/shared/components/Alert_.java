package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.AlertType;
import org.gwtbootstrap3.client.ui.constants.Styles;

import net.hus.core.shared.model.Components.Type;
import net.hus.core.shared.model.UIObject_;

public class Alert_ extends UIObject_
{
  private static final long serialVersionUID = -9041794932112504422L;

  private String mText;
  private AlertType mType;
  private boolean mDismissable;
  private boolean mFade;

  public Alert_()
  {
    setStyleName(Styles.ALERT);
    setType(AlertType.WARNING);
  }

  public Alert_(String inText)
  {
    this();
    mText = inText;
  }

  public Alert_(String inText, AlertType inType)
  {
    this(inText);
    mType = inType;
  }

  public Alert_(String inText, AlertType inType, boolean inDiss, boolean inFade)
  {
    this(inText, inType);
    mDismissable = inDiss;
    mFade = inFade;
  }

  @Override
  public Type cType()
  {
    return Type.ALERT;
  }

  public String getText()
  {
    return mText;
  }

  public void setText(String inText)
  {
    mText = inText;
  }

  public AlertType getType()
  {
    return mType;
  }

  public void setType(AlertType inType)
  {
    mType = inType;
  }

  public boolean isDismissable()
  {
    return mDismissable;
  }

  public void setDismissable(boolean inDismissable)
  {
    mDismissable = inDismissable;
  }

  public boolean isFade()
  {
    return mFade;
  }

  public void setFade(boolean inFade)
  {
    mFade = inFade;
  }
}