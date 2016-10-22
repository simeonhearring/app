package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.Badge_;

public class BadgeParser extends UIObjectParser<Badge_>
{
  public BadgeParser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Badge", Badge_.class);
    inXs.aliasField("Text", Badge_.class, "mText");
  }
}