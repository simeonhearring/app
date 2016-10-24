package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.ListBox;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.View;

public class ListBox_View implements View
{
  private ListBox mView;

  ListBox_View()
  {
  }

  public ListBox_View(ListBox inView)
  {
    mView = inView;
  }

  @Override
  public void setView(String inValue)
  {
    for (int i = 0; i < mView.getItemCount(); i++)
    {
      if (inValue.equals(mView.getValue(i)))
      {
        mView.setSelectedIndex(i);
        break;
      }
    }
  }

  @Override
  public Widget asWidget()
  {
    return mView;
  }
}