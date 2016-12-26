package net.hus.core.client.ui.common;

import net.hus.core.client.ui.event.CssChangeEvent;
import net.hus.core.client.ui.event.ProfileEvent;
import net.hus.core.shared.components.Response;
import net.hus.core.shared.model.CssFileName;

public class EventLocater
{
  public static void fireEvent(String inEvent, Response inResponse)
  {
    if (inEvent != null)
    {
      switch (inEvent)
      {
        case "LoginCommand":
          pLoginCommandBean(inResponse);
          break;
        case "AppCommand":
          pAppCommandBean(inResponse);
          break;
        default:
          break;
      }
    }
  }

  private static void pLoginCommandBean(Response inResponse)
  {
    String[] response = inResponse.getData();

    // 0 See LoginCommandBean.java
    String userName = response[0];
    // 1 See LoginCommandBean.java
    String css = response[1];

    Global.fire(new ProfileEvent(userName));
    if (css != null)
    {
      css = CssFileName.convert(css);
      Global.fire(new CssChangeEvent(css));
    }
  }

  private static void pAppCommandBean(Response inResponse)
  {
    String[] response = inResponse.getData();

    // 0 See AppCommandBean.java
    String userName = response[0];
    // 1 See AppCommandBean.java
    String css = response[1];

    Global.fire(new ProfileEvent(userName));
    if (css != null)
    {
      css = CssFileName.convert(css);
      Global.fire(new CssChangeEvent(css));
    }
  }
}