package net.hus.core.shared.model;

import net.hus.core.shared.util.StringUtil;

public enum YesNoNull implements ItemValue<Boolean>
{
  SELECT_ONE(null),
  YES(Boolean.TRUE),
  NO(Boolean.FALSE);

  private Boolean mValue;

  private YesNoNull(Boolean inValue)
  {
    mValue = inValue;
  }

  @Override
  public Boolean value()
  {
    return mValue;
  }

  @Override
  public String display()
  {
    return StringUtil.toTitle(name().replaceAll("_", " "));
  }

  public static YesNoNull value(Boolean inValue)
  {
    YesNoNull ret = SELECT_ONE;

    if (inValue != null)
    {
      ret = inValue ? YES : NO;
    }

    return ret;
  }
}