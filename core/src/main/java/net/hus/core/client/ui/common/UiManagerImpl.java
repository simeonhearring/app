package net.hus.core.client.ui.common;

import java.util.HashMap;
import java.util.Map;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.model.UiManager;
import net.hus.core.client.ui.TextBox_View;
import net.hus.core.client.ui.View;

public class UiManagerImpl extends UiConverterImpl implements UiManager
{
  private Map<String, IsWidget> mContent = new HashMap<>();

  @Override
  public void add(String inKey, IsWidget inUiO)
  {
    if (inUiO instanceof TextBox)
    {
      TextBox_View uio = new TextBox_View((TextBox) inUiO);
      mContent.put(inKey, uio);
    }
    else
    {
      mContent.put(inKey, inUiO);
    }
  }

  @Override
  public View get(String inKey)
  {
    return (View) mContent.get(inKey);
  }
}