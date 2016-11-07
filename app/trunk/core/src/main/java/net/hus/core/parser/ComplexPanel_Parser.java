package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.ComplexPanel_;

public class ComplexPanel_Parser<T> extends UIObject_Parser<T>
{
  public ComplexPanel_Parser()
  {
    xs((Parser<T>) this);
  }

  @Override
  public void xs(Parser<T> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("ComplexPanel", ComplexPanel_.class);
    inXs.aliasField("Collection", ComplexPanel_.class, "mCollection");

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