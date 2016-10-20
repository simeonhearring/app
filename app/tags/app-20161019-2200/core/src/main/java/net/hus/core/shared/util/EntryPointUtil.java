package net.hus.core.shared.util;

import java.util.HashMap;
import java.util.Map;

public class EntryPointUtil
{
  private static final Map<String, String> CHARMAP;

  static
  {
    CHARMAP = new HashMap<>();
    CHARMAP.put("$", "%24");
    CHARMAP.put("&", "%26");
    CHARMAP.put("+", "%2B");
    CHARMAP.put(",", "%2C");
    CHARMAP.put("/", "%2F");
    CHARMAP.put(":", "%3A");
    CHARMAP.put(";", "%3B");
    CHARMAP.put("=", "%3D");
    CHARMAP.put("?", "%3F");
    CHARMAP.put("@", "%40");
    CHARMAP.put(" ", "%20");
    CHARMAP.put("\"", "%22");
    CHARMAP.put("<", "%3C");
    CHARMAP.put(">", "%3E");
    CHARMAP.put("#", "%23");
    CHARMAP.put("%", "%25");
    CHARMAP.put("{", "%7B");
    CHARMAP.put("}", "%7D");
    CHARMAP.put("|", "%7C");
    CHARMAP.put("\\", "%5C");
    CHARMAP.put("^", "%5E");
    CHARMAP.put("~", "%7E");
    CHARMAP.put("[", "%5B");
    CHARMAP.put("]", "%5D");
    CHARMAP.put("`", "%60");
  }

  private EntryPointUtil()
  {
  }

  public static String encode(String inString)
  {
    StringBuffer buff = new StringBuffer();
    if (inString != null)
    {
      char[] ca = inString.toCharArray();

      for (char c : ca)
      {
        if (CHARMAP.containsKey("" + c))
        {
          buff.append(CHARMAP.get("" + c));
        }
        else
        {
          buff.append(c);
        }
      }
    }
    return buff.toString();
  }

  public static Map<String, String> convert(String inUrl)
  {
    Map<String, String> ret = new HashMap<>();

    if (isValidUrl(inUrl))
    {
      String[] kvPairs = inUrl.split("\\?")[1].split("&");

      for (String kvPair : kvPairs)
      {
        String[] kv = kvPair.split("=");
        if (kv.length > 1)
        {
          String plusToSpace = encode(kv[1]);
          ret.put(kv[0], plusToSpace);
        }
        else
        {
          ret.put(kv[0], "");
        }
      }
    }

    return ret;
  }

  public static boolean isValidUrl(String inUrl)
  {
    return inUrl != null && inUrl.trim().length() > 1 && inUrl.indexOf("?") != -1
        && inUrl.indexOf("&") != -1;
  }
}