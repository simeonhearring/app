package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.ListBox_;

public class ListBoxParser extends FocusWidgetParser<ListBox_>
{
  public ListBoxParser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("ListBox", ListBox_.class);
    inXs.aliasField("LookupParams", ListBox_.class, "mLookupParams");
    inXs.aliasField("Items", ListBox_.class, "mItems");
    inXs.aliasAttribute(ListBox_.class, "mMultipleSelect", "multipleSelect");

    inXs.alias("Item", ListBox_.Item.class);
    inXs.aliasAttribute(ListBox_.Item.class, "mSelected", "selected");
    inXs.aliasField("Text", ListBox_.Item.class, "mText");
    inXs.aliasField("Value", ListBox_.Item.class, "mValue");
  }
}