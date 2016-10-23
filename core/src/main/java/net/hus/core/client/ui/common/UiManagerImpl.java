package net.hus.core.client.ui.common;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.model.UiManager;

public class UiManagerImpl extends UiConverterImpl implements UiManager
{
  private Map<String, IsWidget> mContent = new HashMap<>();

  @Override
  public void add(String inKey, IsWidget inUiO)
  {
    mContent.put(inKey, inUiO);
  }
}