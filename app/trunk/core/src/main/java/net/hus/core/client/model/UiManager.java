package net.hus.core.client.model;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.ui.View;

public interface UiManager extends UiConverter
{
  void add(String inKey, IsWidget inUiO);

  View get(String inKey);
}