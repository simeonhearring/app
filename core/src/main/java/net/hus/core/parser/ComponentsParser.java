package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.AbstractModel;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.UIObject_;

public class ComponentsParser extends XStream implements Parser<Components>
{
  public ComponentsParser()
  {
    alias("Components", Components.class);
    addImplicitCollection(Components.class, "mList", null, UIObject_.class);
    addImplicitCollection(Components.class, "mFieldTKGs", null, FieldTKG.class);

    omitField(Components.class, "mName");
    omitField(Components.class, "mDisplay");
    omitField(AbstractModel.class, "mId");
    omitField(AbstractModel.class, "mCreated");
    omitField(AbstractModel.class, "mUpdated");
    omitField(AbstractModel.class, "mDelete");
    omitField(AbstractModel.class, "mDirty");

    FieldTKG_Parser.xs(this);

    ComplexWidget_Parser.xs((XStream) this);

    ComplexPanel_Parser.xs((XStream) this);

    UIObject_Parser.xs((XStream) this);

    ComponentsParser.xs((XStream) this);
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

  public static void xs(XStream inXs)
  {
    Panel_Parser.xs(inXs);

    Typeahead_Parser.xs(inXs);

    DatePicker_Parser.xs(inXs);

    Button_Parser.xs(inXs);

    FlexTable_Parser.xs(inXs);

    Heading_Parser.xs(inXs);

    AbstractTextWidget_Parser.xs(inXs);

    Badge_Parser.xs(inXs);

    Icon_Parser.xs(inXs);

    FormGroup_Parser.xs(inXs);

    FormLabel_Parser.xs(inXs);

    FieldSet_Parser.xs(inXs);

    TextBox_Parser.xs(inXs);

    Input_Parser.xs(inXs);

    ListBox_Parser.xs(inXs);

    CheckBox_Parser.xs(inXs);
  }
}