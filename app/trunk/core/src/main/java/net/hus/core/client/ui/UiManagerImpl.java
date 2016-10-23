package net.hus.core.client.ui;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.IsWidget;

public class UiManagerImpl implements UiManager
{
  private Map<String, IsWidget> mContent = new HashMap<>();

  @Override
  public void add(String inKey, IsWidget inUiO)
  {
    mContent.put(inKey, inUiO);
  }
}