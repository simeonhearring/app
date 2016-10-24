package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.View;

public class TextBox_View implements View
{
  private TextBox mView;

  TextBox_View()
  {
  }

  public TextBox_View(TextBox inView)
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