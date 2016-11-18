package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Parent for all pages.
 *
 * @author simeonhearring
 * @since October 2016
 */
public interface Display extends IsWidget
{
  void notify(String inMessage);
}