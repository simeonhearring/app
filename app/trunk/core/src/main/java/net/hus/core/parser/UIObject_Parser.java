package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.model.TableKey;
import net.hus.core.shared.model.UIObject_;

public class UIObject_Parser<T> extends XStream implements Parser<T>
{
  public UIObject_Parser()
  {
    xs((Parser<T>) this);
  }

  @Override
  public void xs(Parser<T> inParser)
  {
    xs((XStream) inParser);
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

  public static void xs(XStream inXs)
  {
    inXs.alias("TableKey", TableKey.class);
    inXs.aliasAttribute(TableKey.class, "mTable", "table");
    inXs.aliasAttribute(TableKey.class, "mKey", "key");

    inXs.alias("UIObject", UIObject_.class);
    inXs.aliasField("TABLEKEY", UIObject_.class, "mTableKey");
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
}