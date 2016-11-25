package net.hus.core.client.ui.common;

import java.util.Date;

import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.dom.client.Element;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.shared.model.EnumDisplay;
import net.hus.core.shared.util.EnumUtil;

public abstract class AbstractView extends Composite
{
  public static String format(String inPattern, Date inDate)
  {
    if (inDate == null)
    {
      return "";
    }
    return DateTimeFormat.getFormat(inPattern).format(inDate);
  }

  public static String toString(Long inId)
  {
    return String.valueOf(inId);
  }

  public static Long toLong(String inValue)
  {
    return Long.valueOf(inValue);
  }

  public void notify(String inMessage)
  {
    Notify.notify(inMessage);
  }

  public static void addEnumDToListBox(EnumDisplay[] inValues, ListBox inListBox)
  {
    addEnumDToListBox(inValues, inListBox, false);
  }

  public static void addEnumDToListBox(EnumDisplay[] inValues, ListBox inListBox,
      boolean inSelectOne)
  {
    inListBox.clear();
    if (inSelectOne)
    {
      inListBox.addItem("Select One", "");
    }
    for (EnumDisplay value : inValues)
    {
      inListBox.addItem(value.display(), value.name());
    }
  }

  public static void addEnumToListBox(Enum<?>[] inValues, ListBox inListBox)
  {
    addEnumToListBox(inValues, inListBox, false);
  }

  public static void addEnumToListBox(Enum<?>[] inValues, ListBox inListBox, boolean inSelectOne)
  {
    inListBox.clear();

    if (inSelectOne)
    {
      inListBox.addItem("Select One", "");
    }
    for (Enum<?> value : inValues)
    {
      inListBox.addItem(value.name(), value.name());
    }
  }

  public static void setSelectedIndex(ListBox inListBox, String inValue)
  {
    int index = 0;
    for (int i = 0; i < inListBox.getItemCount(); i++)
    {
      if (inListBox.getValue(i).equals(inValue))
      {
        index = i;
        break;
      }
    }
    inListBox.setSelectedIndex(index);
  }

  public static void setSelectedIndex(ListBox inListBox, Enum<?> inValue)
  {
    if (inValue == null)
    {
      inListBox.setSelectedIndex(0);
    }
    else
    {
      setSelectedIndex(inListBox, inValue.name());
    }
  }

  public static <E extends Enum<?>> E getEnumValueFromListBox(E[] inValues, ListBox inListBox)
  {
    return EnumUtil.valueOf(inListBox.getSelectedValue(), inValues);
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

  public static void addHandler(int inEvent, final Element inElement, EventListener inListner)
  {
    Event.sinkEvents(inElement, inEvent);
    Event.setEventListener(inElement, inListner);
    inElement.setAttribute("contenteditable", "true");
  }

  public static void setScrollHeight(ScrollPanel inScroll, UIObject inOffset, int inMaxHeight)
  {
    inScroll.setHeight(getScrollHeight(inOffset.getOffsetHeight(), inMaxHeight));
  }

  public static String getScrollHeight(int inOffsetHeight, int inMaxHeight)
  {
    String height = null;
    if (inOffsetHeight > inMaxHeight)
    {
      height = inMaxHeight + "px";
    }
    else
    {
      height = inOffsetHeight + "px";
    }
    Notify.notify("" + height + " " + inOffsetHeight + " " + "");
    return height;
  }
}