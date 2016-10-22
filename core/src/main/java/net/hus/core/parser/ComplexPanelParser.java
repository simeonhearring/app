package net.hus.core.parser;

import net.hus.core.client.ui.AbstractTextWidget_;
import net.hus.core.client.ui.ComplexPanel_;
import net.hus.core.client.ui.FormGroup_;
import net.hus.core.client.ui.FormLabel_;
import net.hus.core.client.ui.UIObject_;

public class ComplexPanelParser extends UIObjectParser<UIObject_>
{
  public ComplexPanelParser()
  {
    super();

    alias("ComplexPanel", ComplexPanel_.class);
    aliasField("Collection", ComplexPanel_.class, "mCollection");

    alias("FormGroup", FormGroup_.class);
    aliasAttribute(FormGroup_.class, "mSize", "size");
    aliasAttribute(FormGroup_.class, "mState", "state");

    alias("FormLabel", FormLabel_.class);

    aliasField("Text", AbstractTextWidget_.class, "mText");
    aliasAttribute(AbstractTextWidget_.class, "mHtml", "isHtml");
    aliasAttribute(AbstractTextWidget_.class, "mColor", "color");
    aliasAttribute(AbstractTextWidget_.class, "mMarginBottom", "marginBottom");
    aliasAttribute(AbstractTextWidget_.class, "mMarginLeft", "marginLeft");
    aliasAttribute(AbstractTextWidget_.class, "mMarginRight", "marginRight");
    aliasAttribute(AbstractTextWidget_.class, "mMarginTop", "marginTop");
    aliasAttribute(AbstractTextWidget_.class, "mPaddingBottom", "paddingBottom");
    aliasAttribute(AbstractTextWidget_.class, "mPaddingLeft", "paddingLeft");
    aliasAttribute(AbstractTextWidget_.class, "mPaddingRight", "paddingRight");
    aliasAttribute(AbstractTextWidget_.class, "mPaddingTop", "paddingTop");
    aliasAttribute(AbstractTextWidget_.class, "mPull", "pull");

    FieldSetParser.xs(this);

    TextBoxParser.xs(this);

    InputParser.xs(this);

    ListBoxParser.xs(this);

    CheckBoxParser.xs(this);
  }
}