package net.hus.core.client.ui;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.user.client.ui.Widget;

public class TextBox_View implements View
{
  private TextBox mTextBox;

  TextBox_View()
  {
  }

  public TextBox_View(TextBox inTextBox)
  {
    mTextBox = inTextBox;
  }

  @Override
  public void setValue(String inValue)
  {
    mTextBox.setValue(inValue);
  }

  @Override
  public Widget asWidget()
  {
    return mTextBox;
  }
}