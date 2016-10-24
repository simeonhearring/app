package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.Input;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.View;

public class Input_View implements View
{
  private Input mView;

  Input_View()
  {
  }

  public Input_View(Input inView)
  {
    mView = inView;
  }

  @Override
  public void setView(String inValue)
  {
    mView.setValue(inValue);
  }

  @Override
  public Widget asWidget()
  {
    return mView;
  }
}