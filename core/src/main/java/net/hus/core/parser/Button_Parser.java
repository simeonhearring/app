package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.Button_;

public class Button_Parser extends ComplexWidget_Parser<Button_>
{
  public Button_Parser()
  {
    xs((Parser<Button_>) this);
  }

  @Override
  public void xs(Parser<Button_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Button", Button_.class);
    inXs.aliasField("Text", Button_.class, "mText");
    inXs.aliasAttribute(Button_.class, "mIconType", "iconType");
    inXs.aliasAttribute(Button_.class, "mToggleCaret", "toggleCaret");
    inXs.aliasAttribute(Button_.class, "mDataToggle", "dataToggle");
    inXs.aliasAttribute(Button_.class, "mButtonType", "buttonType");
    inXs.aliasAttribute(Button_.class, "mIconPosition", "iconPosition");
    inXs.aliasAttribute(Button_.class, "mIconFlip", "iconFlip");
    inXs.aliasAttribute(Button_.class, "mIconRotate", "iconRotate");
    inXs.aliasAttribute(Button_.class, "mIconBordered", "iconBordered");
    inXs.aliasAttribute(Button_.class, "mIconInverse", "iconInverse");
    inXs.aliasAttribute(Button_.class, "mIconSpin", "iconSpin");
    inXs.aliasAttribute(Button_.class, "mIconPulse", "iconPulse");
    inXs.aliasAttribute(Button_.class, "mIconFixedWidth", "iconFixedWidth");
    inXs.aliasAttribute(Button_.class, "mBadgeText", "badgeText");
    inXs.aliasAttribute(Button_.class, "mBadgePosition", "badgePosition");
    inXs.aliasAttribute(Button_.class, "mActive", "active");
    inXs.aliasAttribute(Button_.class, "mEnabled", "enabled");
    inXs.aliasAttribute(Button_.class, "mButtonSize", "buttonSize");
    inXs.aliasAttribute(Button_.class, "mIconSize", "iconSize");
    inXs.aliasAttribute(Button_.class, "mCommandName", "command.name");
  }
}