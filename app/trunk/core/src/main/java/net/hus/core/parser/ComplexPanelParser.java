package net.hus.core.parser;

import net.hus.core.client.ui.ComplexPanel_;
import net.hus.core.client.ui.UIObject_;

public class ComplexPanelParser extends UIObjectParser<UIObject_>
{
  public ComplexPanelParser()
  {
    super();

    alias("ComplexPanel", ComplexPanel_.class);
    aliasField("Collection", ComplexPanel_.class, "mCollection");

    FormGroupParser.xs(this);

    FormLabelParser.xs(this);

    FieldSetParser.xs(this);

    TextBoxParser.xs(this);

    InputParser.xs(this);

    ListBoxParser.xs(this);

    CheckBoxParser.xs(this);
  }
}