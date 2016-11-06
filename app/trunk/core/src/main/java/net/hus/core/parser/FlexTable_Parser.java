package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.model.Field;
import net.hus.core.shared.components.FlexTable_;

public class FlexTable_Parser extends UIObject_Parser<FlexTable_>
{
  public FlexTable_Parser()
  {
    xs((Parser<FlexTable_>) this);
  }

  @Override
  public void xs(Parser<FlexTable_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("FlexTable", FlexTable_.class);
    inXs.aliasField("Headers", FlexTable_.class, "mHeaders");
    inXs.aliasField("Types", FlexTable_.class, "mTypes");
    inXs.aliasField("Table", FlexTable_.class, "mTable");
    inXs.aliasAttribute(FlexTable_.class, "mCols", "cols");
    inXs.aliasAttribute(FlexTable_.class, "mHeadingSize", "headingSize");
    inXs.aliasAttribute(FlexTable_.class, "mMaxRows", "maxrows");

    Table_Parser.xs(inXs);

    inXs.alias("Type", Field.Type.class);
  }
}