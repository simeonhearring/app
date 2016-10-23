package net.hus.core.parser;

import net.hus.core.shared.model.ComplexPanel_;
import net.hus.core.shared.model.UIObject_;

public class ComplexPanel_Parser extends UIObject_Parser<UIObject_>
{
  public ComplexPanel_Parser()
  {
    super();

    alias("ComplexPanel", ComplexPanel_.class);
    aliasField("Collection", ComplexPanel_.class, "mCollection");

    FormGroup_Parser.xs(this);

    FormLabel_Parser.xs(this);

    FieldSet_Parser.xs(this);

    TextBox_Parser.xs(this);

    Input_Parser.xs(this);

    ListBox_Parser.xs(this);

    CheckBox_Parser.xs(this);
  }
}