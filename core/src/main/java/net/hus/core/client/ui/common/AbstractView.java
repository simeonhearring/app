package net.hus.core.client.ui.common;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.Widget;

public class AbstractView extends Composite
{
  public static Widget find(String inId, IndexedPanel inPanel)
  {
    Widget ret = null;
    for (int i = 0; i < inPanel.getWidgetCount(); i++)
    {
      Widget widget = inPanel.getWidget(i);
      String id = widget.getElement().getId();
      if (inId.equals(id))
      {
        ret = widget;
      }
    }
    return ret;
  }
}