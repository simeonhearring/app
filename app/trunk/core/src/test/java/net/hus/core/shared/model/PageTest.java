package net.hus.core.shared.model;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Page.Layout;
import net.hus.core.shared.model.Page.Section.Name;

public class PageTest
{
  @Test
  public void testLayoutWeb()
  {
    Name[] values = Page.Section.Name.values(Layout.WEB);
    Assert.assertEquals(3, values.length);
    Assert.assertEquals(Name.LEFT_01, values[0]);
    Assert.assertEquals(Name.CENTER_01, values[1]);
    Assert.assertEquals(Name.RIGHT_01, values[2]);
  }

  @Test
  public void testLayoutAdmin()
  {
    Name[] values = Page.Section.Name.values(Layout.ADMIN);
    Assert.assertEquals(1, values.length);
    Assert.assertEquals(Name.CENTER_01, values[0]);
  }
}