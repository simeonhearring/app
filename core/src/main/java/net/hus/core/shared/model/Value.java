package net.hus.core.shared.model;

import java.util.Date;

public class Value extends AbstractModel
{
  private static final long serialVersionUID = -8854640642880299189L;

  private FieldTKG mFieldTKG;
  private String mValue;
  private int mPos = 0;
  private Long mValueId;
  private Date mAsOf;
  private Field mField;

  private Table mTable;// TODO rename to Array
  private Values mValues; // TODO rename to Table

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

  public String getLabel()
  {
    return getField().getProperties().getDisplay().getLong();
  }

  public void setTable(Table inTable)
  {
    mTable = inTable;
  }

  public Table getTable()
  {
    return mTable;
  }

  public FieldTKG getFieldTKG()
  {
    return mFieldTKG;
  }

  public void setFieldTKG(FieldTKG inFieldTKG)
  {
    mFieldTKG = inFieldTKG;
  }

  public Long getFid()
  {
    return mField.getId();
  }

  public Long getValueId()
  {
    return mValueId;
  }

  public void setValueId(Long inValueId)
  {
    mValueId = inValueId;
  }

  public int getPos()
  {
    return mPos;
  }

  public void setPos(int inPos)
  {
    mPos = inPos;
  }

  public Values getValues()
  {
    return mValues;
  }

  public void setValues(Values inValues)
  {
    mValues = inValues;
  }
}