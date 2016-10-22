package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.AbstractTextWidget_;
import net.hus.core.client.ui.UIObject_;

public class AbstractTextWidgetParser extends UIObjectParser<UIObject_>
{
  public AbstractTextWidgetParser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.aliasField("Text", AbstractTextWidget_.class, "mText");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mHtml", "isHtml");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mColor", "color");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mMarginBottom", "marginBottom");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mMarginLeft", "marginLeft");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mMarginRight", "marginRight");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mMarginTop", "marginTop");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mPaddingBottom", "paddingBottom");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mPaddingLeft", "paddingLeft");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mPaddingRight", "paddingRight");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mPaddingTop", "paddingTop");
    inXs.aliasAttribute(AbstractTextWidget_.class, "mPull", "pull");
  }
}