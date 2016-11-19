package net.hus.core.client.model.common;

import com.google.gwt.user.client.ui.HasText;

import net.hus.core.client.common.Display;

/**
 * LEGACY
 */
public interface Control extends Display, HasText
{
  void setEnabled(boolean inEnabled);

  boolean isEnabled();
}