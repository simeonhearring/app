package net.hus.core.shared.model;

import java.util.ArrayList;
import java.util.List;

public class Fields extends AbstractModel
{
  private static final long serialVersionUID = -7554968452692353425L;

  private String mGroup; // FGG
  private List<Field> mFields;

  private List<Long> mUnique;

  public String fgg()
  {
    return mGroup;
  }

  public void fgg(String inFgg)
  {
    mGroup = inFgg;
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

  public void clear()
  {
    mFields.clear();
  }

  public Boolean contains(Long inId)
  {
    if (mUnique == null)
    {
      mUnique = new ArrayList<>();
      for (Field value : mFields)
      {
        Long id = value.getId();
        if (!mUnique.contains(id))
        {
          mUnique.add(id);
        }
      }
    }
    return mUnique.contains(inId);
  }
}