package net.hus.core.parser;

import com.thoughtworks.xstream.XStream;

import net.hus.core.shared.components.DatePicker_;

public class DatePicker_Parser extends DatePickerBase_Parser<DatePicker_>
{
  public DatePicker_Parser()
  {
    xs((Parser<DatePicker_>) this);
  }

  @Override
  public void xs(Parser<DatePicker_> inParser)
  {
    super.xs(inParser);
    xs((XStream) inParser);
  }

  public static void xs(XStream inXs)
  {
    inXs.alias("DatePicker", DatePicker_.class);
  }
}