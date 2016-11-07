package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.DatePickerBase_;

public class DatePickerBase_Parser<T> extends UIObject_Parser<T>
{
  public DatePickerBase_Parser()
  {
    xs((Parser<T>) this);
  }

  @Override
  public void xs(Parser<T> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("DatePickerBase", DatePickerBase_.class);
  }
}