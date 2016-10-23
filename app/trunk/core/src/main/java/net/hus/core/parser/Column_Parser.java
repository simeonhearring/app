package net.hus.core.parser;

import org.gwtbootstrap3.client.ui.constants.ColumnOffset;
import org.gwtbootstrap3.client.ui.constants.ColumnPull;
import org.gwtbootstrap3.client.ui.constants.ColumnPush;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;

import com.thoughtworks.xstream.XStream;

import net.hus.core.client.ui.Column_;

public class Column_Parser extends ComplexWidget_Parser
{
  public Column_Parser()
  {
    super();
    xs(this);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("Column", Column_.class);
    inXs.aliasAttribute(Column_.class, "mSize", "columnsize");

    inXs.addImplicitArray(Column_.class, "mOtherSize");
    inXs.addImplicitArray(Column_.class, "mPull");
    inXs.addImplicitArray(Column_.class, "mPush");
    inXs.addImplicitArray(Column_.class, "mOffset");

    inXs.alias("Size", ColumnSize.class);
    inXs.alias("Pull", ColumnPull.class);
    inXs.alias("Push", ColumnPush.class);
    inXs.alias("Offset", ColumnOffset.class);
  }
}