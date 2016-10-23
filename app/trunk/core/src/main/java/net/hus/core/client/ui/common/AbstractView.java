package net.hus.core.client.ui.common;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.model.UiManager;

public class AbstractView extends Composite
{
  public UiManager getManager()
  {
    return new UiManagerImpl();
  }

  public static Widget find(String inId, IndexedPanel... inPanel)
  {
    Widget ret = null;
    for (IndexedPanel panel : inPanel)
    {
      for (int i = 0; i < panel.getWidgetCount(); i++)
      {
        Widget widget = panel.getWidget(i);
        String id = widget.getElement().getId();
        if (inId.equals(id))
        {
          ret = widget;
          break;
        }
      }
    }
    return ret;
  }
}