package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.Alert;

import com.google.gwt.user.client.ui.Widget;

public class Alert_View extends StringView
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