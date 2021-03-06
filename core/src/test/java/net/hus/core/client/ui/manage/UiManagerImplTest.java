package net.hus.core.client.ui.manage;

import org.gwtbootstrap3.client.ui.TextBox;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.google.gwtmockito.GwtMockitoTestRunner;

import net.hus.core.client.ui.common.MockUiCreate;
import net.hus.core.shared.components.TextBox_Test;
import net.hus.core.shared.model.Field;

@RunWith(GwtMockitoTestRunner.class)
public class UiManagerImplTest
{
  private UiManager mManager;

  @Before
  public void before()
  {
    mManager = new UiManager(new MockUiCreate());
    Assert.assertNotNull(mManager);
  }

  @Test
  public void canCreateAndFindTextBox()
  {
    String key = Field.Component.FV00_ + "1";

    TextBox uiobject = (TextBox) mManager.match(TextBox_Test.newTextBox(key));

    UiObjects views = mManager.get(key + "_0");
    Assert.assertEquals(1, views.getComponents().size());
    Assert.assertEquals(uiobject, views.getComponents().get(0).getComponent());

    uiobject.setText("Hello");
    Assert.assertEquals("", uiobject.getText());

    Mockito.when(uiobject.getText()).thenReturn("Hello");
    Assert.assertEquals("Hello", uiobject.getText());
  }
}