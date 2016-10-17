package net.hus.core.model;

import java.util.List;

public class Fields
{
  private String mGroup;
  private List<Field> mFields;

  public String getGroup()
  {
    return mGroup;
  }

  public void setGroup(String inGroup)
  {
    mGroup = inGroup;
  }

  public List<Field> getFields()
  {
    return mFields;
  }

  public void setFields(List<Field> inFields)
  {
    mFields = inFields;
  }

  public void add(Field inField)
  {
    mFields.add(inField);
  }
}