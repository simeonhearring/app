package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.Field;

public class Lookup_Parser
{
  public static void xs(XStream inXs)
  {
    inXs.alias("Lookup", Field.Lookup.class);
    inXs.aliasAttribute(Field.Lookup.class, "mLocation", "loc");
    inXs.aliasAttribute(Field.Lookup.class, "mParameters", "params");
  }
}