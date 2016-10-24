package net.hus.core.shared.model;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.ComponentsParser;
import net.hus.core.util.ResourceUtil;

public class ComponentsTest
{
  @Test
  public void canParse()
  {
    ComponentsParser parser = new ComponentsParser();

    String xml = ResourceUtil.contents("net/hus/core/shared/model/Components.xml");

    Assert.assertEquals(2, parser.fromXml(xml).components().size());
  }
}