package net.hus.core.model;

import java.util.Date;

import net.hus.core.shared.model.FlexTable_.Table;

public class Value extends AbstractModel
{
  private static final long serialVersionUID = -8854640642880299189L;

  private TableFvk mTableFvk;
  private String mValue;
  private Date mAsOf;
  private Field mField;

  private Table mTable;

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

  public TableFvk getTableFvk()
  {
    return mTableFvk;
  }

  public void setTableFvk(TableFvk inTableFvk)
  {
    mTableFvk = inTableFvk;
  }

  public Long getFid()
  {
    return mField.getId();
  }
}