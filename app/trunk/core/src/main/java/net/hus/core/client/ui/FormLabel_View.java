package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.FormLabel;

import com.google.gwt.user.client.ui.Widget;

public class FormLabel_View extends StringView
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