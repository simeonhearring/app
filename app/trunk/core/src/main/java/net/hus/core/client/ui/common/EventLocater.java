package net.hus.core.client.ui.common;

import net.hus.core.client.ui.event.CssChangeEvent;
import net.hus.core.client.ui.event.ProfileEvent;
import net.hus.core.shared.components.Response;

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
      Global.fire(new CssChangeEvent(css));
    }
  }
}