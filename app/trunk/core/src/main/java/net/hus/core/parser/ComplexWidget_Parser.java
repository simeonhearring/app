package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.ComplexWidget_;

public class ComplexWidget_Parser extends ComplexPanel_Parser
{
  public ComplexWidget_Parser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("ComplexWidget", ComplexWidget_.class);
    inXs.aliasAttribute(ComplexWidget_.class, "mColor", "color");
    inXs.aliasAttribute(ComplexWidget_.class, "mMarginBottom", "marginBottom");
    inXs.aliasAttribute(ComplexWidget_.class, "mMarginLeft", "marginLeft");
    inXs.aliasAttribute(ComplexWidget_.class, "mMarginRight", "marginRight");
    inXs.aliasAttribute(ComplexWidget_.class, "mMarginTop", "marginTop");
    inXs.aliasAttribute(ComplexWidget_.class, "mPaddingBottom", "paddingBottom");
    inXs.aliasAttribute(ComplexWidget_.class, "mPaddingLeft", "paddingLeft");
    inXs.aliasAttribute(ComplexWidget_.class, "mPaddingRight", "paddingRight");
    inXs.aliasAttribute(ComplexWidget_.class, "mPaddingTop", "paddingTop");
    inXs.aliasAttribute(ComplexWidget_.class, "mPull", "pull");
  }
}