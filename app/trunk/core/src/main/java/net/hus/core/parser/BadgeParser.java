package net.hus.core.parser;

import net.hus.core.client.ui.Badge_;

public class BadgeParser extends UIObjectParser<Badge_>
{
  public BadgeParser()
  {
    super();

    alias("Badge", Badge_.class);
    aliasField("Text", Badge_.class, "mText");
  }
}