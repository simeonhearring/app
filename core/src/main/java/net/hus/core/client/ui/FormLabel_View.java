package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.FormLabel;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.StringView;

public class FormLabel_View implements StringView
{
  private FormLabel mView;

  FormLabel_View()
  {
  }

  public FormLabel_View(FormLabel inView)
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