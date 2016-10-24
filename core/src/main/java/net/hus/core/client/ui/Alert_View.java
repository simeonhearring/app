package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.Alert;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.View;

public class Alert_View implements View
{
  private Alert mView;

  Alert_View()
  {
  }

  public Alert_View(Alert inView)
  {
    mView = inView;
  }

  @Override
  public void setView(String inValue)
  {
    mView.setText(inValue);
  }

  @Override
  public Widget asWidget()
  {
    return mView;
  }
}