package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.ListBox;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;

import net.hus.core.model.TableFvk;

public class ListBox_View extends Abstract_View<ListBox, String> implements ChangeHandler
{
  public ListBox_View(String inKey, ListBox inComponent)
  {
    super(inKey, inComponent);
  }

  @Override
  public void setTableKey(TableFvk inTableKey)
  {
    super.setTableKey(inTableKey);
    mComponent.addChangeHandler(this);
  }

  @Override
  public void setValue(String inValue)
  {
    for (int i = 0; i < mComponent.getItemCount(); i++)
    {
      if (inValue.equals(mComponent.getValue(i)))
      {
        mComponent.setSelectedIndex(i);
        break;
      }
    }
  }

  @Override
  public void onChange(ChangeEvent inEvent)
  {
    save(mComponent.getSelectedValue(), mComponent.getSelectedItemText());
  }
}