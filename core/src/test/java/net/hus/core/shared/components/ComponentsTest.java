package net.hus.core.shared.components;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Components;

public class ComponentsTest
{
  @Test
  public void test()
  {
    Assert.assertEquals("Alert", Components.Type.ALERT.display());
    Assert.assertEquals("CheckBox", Components.Type.CHECK_BOX.display());
  }
}