package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.model.Components;
import net.hus.core.util.ResourceUtil;

public class ComponentsParserTest
{
  @Test
  public void canParse()
  {
    ComponentsParser parser = new ComponentsParser();

    String xml = ResourceUtil.contents("net/hus/core/shared/model/Components.xml");

    Components model = parser.fromXml(xml);
    Assert.assertEquals(2, model.components().size());

    Assert.assertEquals(xml, parser.toXml(model));
  }
}