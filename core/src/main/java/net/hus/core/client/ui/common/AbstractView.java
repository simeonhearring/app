package net.hus.core.client.ui.common;

import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.shared.model.EnumDisplay;

public abstract class AbstractView extends Composite
{
  public void notify(String inMessage)
  {
    Notify.notify(inMessage);
  }

  public static void addEnumToListBox(EnumDisplay[] inValues, ListBox inListBox)
  {
    inListBox.clear();
    for (EnumDisplay value : inValues)
    {
      inListBox.addItem(value.display(), value.name());
    }
  }

  public static void setEnumValueToListBox(EnumDisplay inValue, ListBox inListBox)
  {
    if (inValue == null)
    {
      inListBox.setSelectedIndex(0);
    }
    else
    {
      for (int i = 0; i < inListBox.getItemCount(); i++)
      {
        String value = inListBox.getValue(i);
        if (value.equals(inValue.name()))
        {
          inListBox.setSelectedIndex(i);
        }
      }
    }
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