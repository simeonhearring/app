package net.hus.core.shared.util;

import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.http.client.URL;

public final class JsniUtil
{
  private JsniUtil()
  {
  }

  public static void unescape(Map<String, String> inMap)
  {
    if (GWT.isClient())
    {
      for (Map.Entry<String, String> entry : inMap.entrySet())
      {
        entry.setValue(unescapeNative(entry.getValue()));
      }
    }
  }

  public static void launchFrame(String inLink, String inFrame)
  {
    if (GWT.isClient())
    {
      launchFrameNative(inLink, inFrame);
    }
  }

  public static void launchFrame(String inUrl, String inFrame, String inParams)
  {
    if (GWT.isClient())
    {
      launchFrameNative(inUrl, inFrame, inParams);
    }
  }

  public static void setWindowLocation(String inUrl)
  {
    if (GWT.isClient())
    {
      setWindowLocationNative(inUrl);
    }
  }

  public static void reload()
  {
    if (GWT.isClient())
    {
      reloadNative();
    }
  }

  public static String getUrl()
  {
    if (GWT.isClient())
    {
      return getUrlNative();
    }
    else
    {
      return null;
    }
  }

  public static void mailTo(String inAddress, String inSubject, String inBody)
  {
    if (GWT.isClient())
    {
      mailToNative(inAddress, URL.encode(inSubject), URL.encode(inBody));
    }
  }

  private static native void reloadNative()
  /*-{
		document.location.reload(true);
  }-*/;

  public static native String getUserAgent()
  /*-{
		return navigator.userAgent.toLowerCase();
  }-*/;

  public static native String stringify(JavaScriptObject inJso)
  /*-{
		return JSON.stringify(inJso);
  }-*/;

  public static native JavaScriptObject parse(String inString)
  /*-{
		return JSON.parse(inString);
  }-*/;

  private native Element getHead()
  /*-{
		return $doc.getElementsByTagName('head')[0];
  }-*/;

  private static native void mailToNative(String inAddress, String inSubject, String inBody)
  /*-{
		$wnd.location = "mailto:" + inAddress + "?subject=" + inSubject
				+ "&body=" + inBody;
  }-*/;

  private static native String unescapeNative(String inVal)
  /*-{
		return unescape(inVal);
  }-*/;

  private static native String getUrlNative()
  /*-{
		return $wnd.location.href;
  }-*/;

  private static native void setWindowLocationNative(String inUrl)
  /*-{
		$wnd.location.href = inUrl;
  }-*/;

  private static native void launchFrameNative(String inUrl, String inFrame, String inParams)
  /*-{
		$wnd.open(inUrl, inFrame, inParams);
  }-*/;

  private static native void launchFrameNative(String inLink, String inFrame)
  /*-{
		$wnd.top.LnkC(inLink, inFrame, $wnd);
  }-*/;
}
