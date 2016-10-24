package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.UIObject_;

public class UIObject_Parser<T> extends XStream implements Parser<T>
{
  public UIObject_Parser()
  {
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("UIObject", UIObject_.class);
    inXs.aliasField("Title", UIObject_.class, "mTitle");
    inXs.aliasAttribute(UIObject_.class, "mSection", "SECTION");
    inXs.aliasAttribute(UIObject_.class, "mKey", "KEY");
    inXs.aliasAttribute(UIObject_.class, "mId", "id");
    inXs.aliasAttribute(UIObject_.class, "mVisible", "visible");
    inXs.aliasAttribute(UIObject_.class, "mHeight", "height");
    inXs.aliasAttribute(UIObject_.class, "mWidth", "width");
    inXs.aliasAttribute(UIObject_.class, "mStyleName", "styleName");
    inXs.aliasAttribute(UIObject_.class, "mStylePrimaryName", "stylePrimaryName");
  }

  @SuppressWarnings("unchecked")
  @Override
  public T fromXml(String inValue)
  {
    return (T) super.fromXML(inValue);
  }

  @Override
  public String toXml(T inObj)
  {
    return super.toXML(inObj);
  }
}