package net.hus.core.shared.components;

import org.junit.Test;

import junit.framework.Assert;

public class ComponentsTest
{
  @Test
  public void test()
  {
    Assert.assertEquals("Alert", Components.Type.ALERT.display());
    Assert.assertEquals("CheckBox", Components.Type.CHECK_BOX.display());
  }
}