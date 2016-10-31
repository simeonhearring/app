package net.hus.core.shared.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.model.TableFvk;
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

    Components model = new Components();
    List<TableFvk> list = new ArrayList<>();
    list.add(new TableFvk("JUNIT", "-1", null));
    model.setTableFvks(list);

    System.out.println(parser.toXml(model));
  }
}