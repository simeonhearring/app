package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.UIObject_;

public class UIObject_Parser<T> extends XStream implements Parser<T>
{
  public UIObject_Parser()
  {
    alias("UIObject", UIObject_.class);
    aliasField("Title", UIObject_.class, "mTitle");
    aliasAttribute(UIObject_.class, "mKey", "KEY");
    aliasAttribute(UIObject_.class, "mId", "id");
    aliasAttribute(UIObject_.class, "mVisible", "visible");
    aliasAttribute(UIObject_.class, "mHeight", "height");
    aliasAttribute(UIObject_.class, "mWidth", "width");
    aliasAttribute(UIObject_.class, "mStyleName", "styleName");
    aliasAttribute(UIObject_.class, "mStylePrimaryName", "stylePrimaryName");
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