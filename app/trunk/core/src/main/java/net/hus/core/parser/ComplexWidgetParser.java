package net.hus.core.parser;

import net.hus.core.client.ui.ComplexWidget_;

public class ComplexWidgetParser extends ComplexPanelParser
{
  public ComplexWidgetParser()
  {
    super();

    alias("ComplexWidget", ComplexWidget_.class);
    aliasAttribute(ComplexWidget_.class, "mColor", "color");
    aliasAttribute(ComplexWidget_.class, "mMarginBottom", "marginBottom");
    aliasAttribute(ComplexWidget_.class, "mMarginLeft", "marginLeft");
    aliasAttribute(ComplexWidget_.class, "mMarginRight", "marginRight");
    aliasAttribute(ComplexWidget_.class, "mMarginTop", "marginTop");
    aliasAttribute(ComplexWidget_.class, "mPaddingBottom", "paddingBottom");
    aliasAttribute(ComplexWidget_.class, "mPaddingLeft", "paddingLeft");
    aliasAttribute(ComplexWidget_.class, "mPaddingRight", "paddingRight");
    aliasAttribute(ComplexWidget_.class, "mPaddingTop", "paddingTop");
    aliasAttribute(ComplexWidget_.class, "mPull", "pull");
  }
}