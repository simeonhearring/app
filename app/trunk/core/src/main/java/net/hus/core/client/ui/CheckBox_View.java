package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.CheckBox;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.View;

public class CheckBox_View implements View
{
  private CheckBox mView;

  CheckBox_View()
  {
  }

  public CheckBox_View(CheckBox inView)
  {
    mView = inView;
  }

  @Override
  public void setView(String inValue)
  {
    mView.setValue(Boolean.valueOf(inValue));
  }

  @Override
  public Widget asWidget()
  {
    return mView;
  }
}