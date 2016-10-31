package net.hus.core.client.ui.common;

import org.gwtbootstrap3.client.ui.TextBox;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.google.gwtmockito.GwtMockitoTestRunner;

import net.hus.core.model.Field;
import net.hus.core.shared.model.TextBox_Test;

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

    Views<Object> views = mManager.get(key);
    Assert.assertEquals(1, views.getViews().size());
    Assert.assertEquals(uiobject, views.getViews().get(0).asWidget());

    uiobject.setText("Hello");
    Assert.assertEquals("", uiobject.getText());

    Mockito.when(uiobject.getText()).thenReturn("Hello");
    Assert.assertEquals("Hello", uiobject.getText());
  }
}