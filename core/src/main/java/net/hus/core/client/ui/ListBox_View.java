package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.ListBox;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Widget;

public class ListBox_View extends Abstract_View implements ChangeHandler
{
  private ListBox mView;

  public ListBox_View(String inKey, ListBox inView)
  {
    super(inKey);
    mView = inView;
    mView.addChangeHandler(this);
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

  @Override
  public void onChange(ChangeEvent inEvent)
  {
    save(mView.getSelectedValue(), mView.getSelectedItemText());
  }
}