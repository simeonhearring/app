package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.Badge_;

public class Badge_Parser extends UIObject_Parser<Badge_>
{
  public Badge_Parser()
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