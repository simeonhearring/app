package net.hus.core.client.model;

import com.google.gwt.user.client.ui.IsWidget;

public interface UiManager extends UiConverter
{
  void add(String inKey, IsWidget inUiO);
}