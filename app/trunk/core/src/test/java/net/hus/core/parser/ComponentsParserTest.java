package net.hus.core.parser;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.shared.components.ComplexPanel_;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.util.ResourceUtil;

public class ComponentsParserTest
{
  @Test
  public void canParse()
  {
    ComponentsParser parser = new ComponentsParser();

    String xml = ResourceUtil.contents("Components1.xml");

    String x =
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<Components xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"Components.xsd\">";
    Components model = parser.fromXml(xml);
    Assert.assertEquals(1, model.components().size());
    xml = xml.replaceAll("\t", "  ").replaceAll("\" />", "\"/>");

    Assert.assertEquals(xml, x + parser.toXml(model).replaceAll("<Components>", ""));
  }

  @Test
  public void canConvertToJson()
  {
    ComponentsParser parser = new ComponentsParser();
    String xml = ResourceUtil.contents("Components1.xml");
    Components model = parser.fromXml(xml);

    StringBuilder sb = new StringBuilder();
    add(model.getList(), sb);

    System.out.println("[" + sb.toString() + "]");
  }

  private void add(List<UIObject_> inList, StringBuilder inSb)
  {
    if (inList != null)
    {
      boolean notFirst = false;

      for (UIObject_ value : inList)
      {
        String simpleName = value.getClass().getSimpleName();

        if (notFirst)
        {
          inSb.append(",");
        }
        notFirst = true;

        inSb.append("\n{ \n\"text\":").append(" \"" + simpleName + "\"");

        if (value instanceof ComplexPanel_)
        {
          List<UIObject_> collection = ((ComplexPanel_) value).getCollection();

          if (collection != null && collection.size() != 0)
          {
            inSb.append(",\n\"nodes\": [");

            add(collection, inSb);

            inSb.append("]");
          }
        }
        inSb.append("}");
      }
    }
  }
}