package net.hus.core.client.ui.common;

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
          Global.fire(new ProfileEvent(inResponse));
          break;

        default:
          break;
      }
    }
  }
}