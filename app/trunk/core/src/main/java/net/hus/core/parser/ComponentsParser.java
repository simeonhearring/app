package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.Components;
import net.hus.core.shared.components.UIObject_;
import net.hus.core.shared.model.FieldTKG;

public class ComponentsParser extends XStream implements Parser<Components>
{
  public ComponentsParser()
  {
    alias("Components", Components.class);
    addImplicitCollection(Components.class, "mList", null, UIObject_.class);
    addImplicitCollection(Components.class, "mFieldTKGs", null, FieldTKG.class);

    FieldTKG_Parser.xs(this);

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