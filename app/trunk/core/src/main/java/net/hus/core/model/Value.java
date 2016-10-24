package net.hus.core.model;

import java.util.Date;

public class Value extends AbstractModel
{
  private static final long serialVersionUID = -8854640642880299189L;

  private String mKey;
  private String mValue;
  private Date mAsOf;
  private Field mField;

  public String getKey()
  {
    return mKey;
  }

  public void setKey(String inKey)
  {
    mKey = inKey;
  }

  public String getValue()
  {
    return mValue;
  }

  public void setValue(String inValue)
  {
    mValue = inValue;
  }

  public Date getAsOf()
  {
    return mAsOf;
  }

  public void setAsOf(Date inAsOf)
  {
    mAsOf = inAsOf;
  }

  public Field getField()
  {
    return mField;
  }

  public void setField(Field inField)
  {
    mField = inField;
  }
}