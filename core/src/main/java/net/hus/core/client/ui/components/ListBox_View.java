package net.hus.core.client.ui.components;

import org.gwtbootstrap3.client.ui.ListBox;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;

import net.hus.core.shared.model.Value;
import net.hus.core.shared.util.NumberUtil;

public class ListBox_View extends Abstract_View<ListBox> implements ChangeHandler
{
  public ListBox_View(ListBox inComponent)
  {
    super(inComponent);
  }

  @Override
  public void addChangeHandler()
  {
    mComponent.addChangeHandler(this);
  }

  @Override
  public void setValue(Value inValue)
  {
    String value = String.valueOf(inValue.getValueId());
    for (int i = 0; i < mComponent.getItemCount(); i++)
    {
      if (value.equals(mComponent.getValue(i)))
      {
        mComponent.setSelectedIndex(i);
        break;
      }
    }
  }

  @Override
  public void onChange(ChangeEvent inEvent)
  {
    Long selectedValueId = NumberUtil.toLong(mComponent.getSelectedValue());
    String selectedItemText = mComponent.getSelectedItemText();
    save(selectedItemText, selectedValueId, selectedItemText);
  }
}