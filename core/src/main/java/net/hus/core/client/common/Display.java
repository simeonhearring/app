package net.hus.core.client.common;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.model.UiManager;

public interface Display extends IsWidget
{
  UiManager getManager();
}