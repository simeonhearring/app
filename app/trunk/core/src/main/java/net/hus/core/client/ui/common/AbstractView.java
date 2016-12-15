package net.hus.core.client.ui.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.ui.event.Event;
import net.hus.core.shared.model.EnumDisplay;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.util.EnumUtil;
import net.hus.core.shared.util.NumberUtil;

public abstract class AbstractView extends Composite
{
  private List<HandlerRegistration> mRegistration = new ArrayList<>();

  protected void add(HandlerRegistration inRegistration)
  {
    mRegistration.add(inRegistration);
  }

  protected void clearRegistration()
  {
    for (HandlerRegistration value : mRegistration)
    {
      value.removeHandler();
    }
    mRegistration.clear();
  }

  public void fireDeferred(final Event<?> inEvent)
  {
    Scheduler.get().scheduleDeferred(new ScheduledCommand()
    {
      @Override
      public void execute()
      {
        Global.fire(inEvent);
      }
    });
  }

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

  public boolean confirm(String inMessage)
  {
    return Window.confirm(inMessage);
  }

  public void warn(String inMessage)
  {
    Notify.notify(inMessage, NotifyType.WARNING);
  }

  public void danger(String inMessage)
  {
    Notify.notify(inMessage, NotifyType.DANGER);
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

  public static void setSelectedIndex(ListBox inBox, String inValue)
  {
    for (int i = 0; i < inBox.getItemCount(); i++)
    {
      if (inBox.getValue(i).equals(inValue))
      {
        inBox.setSelectedIndex(i);
        break;
      }
    }
  }

  public static <E extends Enum<?>> E getEnumValueFromListBox(E[] inValues, ListBox inListBox)
  {
    return EnumUtil.valueOf(inListBox.getSelectedValue(), inValues);
  }

  public static void addLookupAltToListBox(ListBox inBox, List<Lookup> inLookups)
  {
    for (Lookup value : inLookups)
    {
      inBox.addItem(value.getDisplay(), value.getAltId().toString());
    }
  }

  public static void addLookupNameToListBox(ListBox inBox, List<Lookup> inLookups)
  {
    for (Lookup value : inLookups)
    {
      inBox.addItem(value.getDisplay(), value.getCode());
    }
  }

  public static Long getListBoxLongValue(ListBox inBox)
  {
    return NumberUtil.toLong(inBox.getSelectedValue());
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
    com.google.gwt.user.client.Event.sinkEvents(inElement, inEvent);
    com.google.gwt.user.client.Event.setEventListener(inElement, inListner);
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