package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.Label;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.View;

public class Label_View implements View
{
  private Label mView;

  Label_View()
  {
  }

  public Label_View(Label inView)
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