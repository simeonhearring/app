package net.hus.core.shared.model;

import org.junit.Test;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Display;
import net.hus.core.client.ui.common.MockUiCreate;
import net.hus.core.client.ui.common.UiManager;

public class UiManagerImplTest
{
  @Test
  public void test()
  {
    UiManager model = new UiManager(new MockUiCreate());
    model.add("", new Display()
    {
      @Override
      public Widget asWidget()
      {
        return null;
      }
    });
  }
}