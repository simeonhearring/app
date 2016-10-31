package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.model.TableFvk;

public class TableFvk_Parser extends XStream implements Parser<TableFvk>
{
  public TableFvk_Parser()
  {
    xs((Parser<TableFvk>) this);
  }

  @Override
  public void xs(Parser<TableFvk> inParser)
  {
    xs((XStream) inParser);
  }

  @Override
  public TableFvk fromXml(String inValue)
  {
    return (TableFvk) super.fromXML(inValue);
  }

  @Override
  public String toXml(TableFvk inObj)
  {
    return super.toXML(inObj);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("TableFvk", TableFvk.class);
    inXs.aliasAttribute(TableFvk.class, "mFvt", "fvt");
    inXs.aliasAttribute(TableFvk.class, "mFvk", "fvk");
    inXs.aliasAttribute(TableFvk.class, "mFgg", "fgg");
  }
}