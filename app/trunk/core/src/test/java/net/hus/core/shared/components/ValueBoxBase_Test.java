package net.hus.core.shared.components;

import org.gwtbootstrap3.client.ui.constants.InputSize;

public class ValueBoxBase_Test
{
  public static void initValueBoxBase(ValueBoxBase_ inOut)
  {
    inOut.setAllowBlank(true);
    inOut.setAutoComplete(true);
    inOut.setMaxLength(10);
    inOut.setPlaceholder("placeholder");
    inOut.setSize(InputSize.LARGE);

    FocusWidget_Test.initFocusWidget(inOut);
  }
}