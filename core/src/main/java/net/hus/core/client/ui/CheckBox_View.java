package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.CheckBox;

import com.google.gwt.user.client.ui.Widget;

public class CheckBox_View extends StringView
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