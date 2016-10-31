package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.model.TableFvk;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.UIObject_;

public class ComponentsParser extends XStream implements Parser<Components>
{
  public ComponentsParser()
  {
    alias("Components", Components.class);
    addImplicitCollection(Components.class, "mList", null, UIObject_.class);
    addImplicitCollection(Components.class, "mTableFvks", null, TableFvk.class);

    ComplexWidget_Parser.xs((XStream) this);

    ComplexPanel_Parser.xs((XStream) this);

    UIObject_Parser.xs((XStream) this);
  }

  @Override
  public Components fromXml(String inValue)
  {
    return (Components) super.fromXML(inValue);
  }

  @Override
  public String toXml(Components inObj)
  {
    return super.toXML(inObj);
  }

  @Override
  public void xs(Parser<Components> inParser)
  {
  }
}