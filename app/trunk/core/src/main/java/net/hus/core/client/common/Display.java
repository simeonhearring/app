package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.ui.event.Event;

/**
 * Parent for all pages.
 *
 * @author simeonhearring
 * @since October 2016
 */
public interface Display extends IsWidget
{
  void notify(String inMessage);

  void warn(String inMessage);

  void danger(String inMessage);

  void fireDeferred(Event<?> inEvent);
}