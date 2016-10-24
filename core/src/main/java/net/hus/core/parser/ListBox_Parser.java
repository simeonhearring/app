package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.model.ListBox_;

public class ListBox_Parser extends FocusWidget_Parser<ListBox_>
{
  public ListBox_Parser()
  {
    xs((Parser<ListBox_>) this);
  }

  @Override
  public void xs(Parser<ListBox_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
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