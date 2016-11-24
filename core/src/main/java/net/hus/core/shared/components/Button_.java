package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.BadgePosition;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Toggle;

import net.hus.core.shared.model.Components.Type;
import net.hus.core.shared.rpc.HasCommandName;

public class Button_ extends ComplexWidget_ implements HasCommandName
{
  private static final long serialVersionUID = -7191773392942086895L;

  private String mText;
  private IconType mIconType;
  private Boolean mToggleCaret;
  private Toggle mDataToggle;
  private ButtonType mButtonType;

  //
  private IconPosition mIconPosition;
  private IconSize mIconSize;
  private IconFlip mIconFlip;
  private IconRotate mIconRotate;
  private Boolean mIconBordered;
  private Boolean mIconInverse;
  private Boolean mIconSpin;
  private Boolean mIconPulse;
  private Boolean mIconFixedWidth;
  private String mBadgeText;
  private BadgePosition mBadgePosition;

  //
  private Boolean mActive;
  private Boolean mEnabled;
  private ButtonSize mButtonSize;

  //
  private String mCommandName;

  @Override
  public Type cType()
  {
    return Type.BUTTON;
  }

  public String getText()
  {
    return mText;
  }

  public void setText(String inText)
  {
    mText = inText;
  }

  public IconType getIconType()
  {
    return mIconType;
  }

  public void setIconType(IconType inIconType)
  {
    mIconType = inIconType;
  }

  public Boolean getToggleCaret()
  {
    return mToggleCaret;
  }

  public void setToggleCaret(Boolean inToggleCaret)
  {
    mToggleCaret = inToggleCaret;
  }

  public Toggle getDataToggle()
  {
    return mDataToggle;
  }

  public void setDataToggle(Toggle inDataToggle)
  {
    mDataToggle = inDataToggle;
  }

  public ButtonType getButtonType()
  {
    return mButtonType;
  }

  public void setButtonType(ButtonType inButtonType)
  {
    mButtonType = inButtonType;
  }

  public IconPosition getIconPosition()
  {
    return mIconPosition;
  }

  public void setIconPosition(IconPosition inIconPosition)
  {
    mIconPosition = inIconPosition;
  }

  public IconSize getIconSize()
  {
    return mIconSize;
  }

  public void setIconSize(IconSize inIconSize)
  {
    mIconSize = inIconSize;
  }

  public IconFlip getIconFlip()
  {
    return mIconFlip;
  }

  public void setIconFlip(IconFlip inIconFlip)
  {
    mIconFlip = inIconFlip;
  }

  public IconRotate getIconRotate()
  {
    return mIconRotate;
  }

  public void setIconRotate(IconRotate inIconRotate)
  {
    mIconRotate = inIconRotate;
  }

  public Boolean getIconBordered()
  {
    return mIconBordered;
  }

  public void setIconBordered(Boolean inIconBordered)
  {
    mIconBordered = inIconBordered;
  }

  public Boolean getIconInverse()
  {
    return mIconInverse;
  }

  public void setIconInverse(Boolean inIconInverse)
  {
    mIconInverse = inIconInverse;
  }

  public Boolean getIconSpin()
  {
    return mIconSpin;
  }

  public void setIconSpin(Boolean inIconSpin)
  {
    mIconSpin = inIconSpin;
  }

  public Boolean getIconPulse()
  {
    return mIconPulse;
  }

  public void setIconPulse(Boolean inIconPulse)
  {
    mIconPulse = inIconPulse;
  }

  public Boolean getIconFixedWidth()
  {
    return mIconFixedWidth;
  }

  public void setIconFixedWidth(Boolean inIconFixedWidth)
  {
    mIconFixedWidth = inIconFixedWidth;
  }

  public String getBadgeText()
  {
    return mBadgeText;
  }

  public void setBadgeText(String inBadgeText)
  {
    mBadgeText = inBadgeText;
  }

  public BadgePosition getBadgePosition()
  {
    return mBadgePosition;
  }

  public void setBadgePosition(BadgePosition inBadgePosition)
  {
    mBadgePosition = inBadgePosition;
  }

  public Boolean getActive()
  {
    return mActive;
  }

  public void setActive(Boolean inActive)
  {
    mActive = inActive;
  }

  public Boolean getEnabled()
  {
    return mEnabled;
  }

  public void setEnabled(Boolean inEnabled)
  {
    mEnabled = inEnabled;
  }

  public ButtonSize getButtonSize()
  {
    return mButtonSize;
  }

  public void setButtonSize(ButtonSize inButtonSize)
  {
    mButtonSize = inButtonSize;
  }

  @Override
  public String commandName()
  {
    return mCommandName;
  }

  public void setCommandName(String inCommandName)
  {
    mCommandName = inCommandName;
  }
}