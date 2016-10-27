package net.hus.core.shared.model;

import org.junit.Test;

import com.google.gwt.user.client.ui.Widget;

import net.hus.core.client.common.Display;
import net.hus.core.client.model.UiManager;
import net.hus.core.client.ui.common.UiManagerImpl;

public class UiManagerImplTest
{
  @Test
  public void test()
  {
    UiManagerImpl model = new UiManagerImpl();
    model.add("", new Display()
    {
      @Override
      public Widget asWidget()
      {
        return null;
      }

      @Override
      public UiManager getManager()
      {
        return null;
      }
    });
  }
}