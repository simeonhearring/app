package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.Badge;

import com.google.gwt.user.client.ui.Widget;

public class Badge_View extends StringView
{
  private Badge mView;

  Badge_View()
  {
  }

  public Badge_View(Badge inView)
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