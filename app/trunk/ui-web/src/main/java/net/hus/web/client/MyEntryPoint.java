package net.hus.web.client;

import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import net.hus.core.client.AbstractEntryPoint;
import net.hus.core.client.ui.event.LoadMainEvent;

public class MyEntryPoint extends AbstractEntryPoint
{
  @Override
  public void dispatch(LoadMainEvent inEvent)
  {
    Notify.notify("Alert");
  }
}