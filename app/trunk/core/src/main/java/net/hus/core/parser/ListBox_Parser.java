package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.ListBox_;
import net.hus.core.shared.model.Field;

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
    inXs.aliasField("Lookup", ListBox_.class, "mLookup");
    inXs.aliasField("Items", ListBox_.class, "mItems");
    inXs.aliasAttribute(ListBox_.class, "mMultipleSelect", "multipleSelect");

    inXs.alias("Lookup", Field.Lookup.class);
    inXs.aliasAttribute(Field.Lookup.class, "mLocation", "loc");
    inXs.aliasAttribute(Field.Lookup.class, "mParameters", "params");

    inXs.alias("Item", ListBox_.Item.class);
    inXs.aliasAttribute(ListBox_.Item.class, "mSelected", "selected");
    inXs.aliasField("Text", ListBox_.Item.class, "mText");
    inXs.aliasField("Value", ListBox_.Item.class, "mValue");
  }
}