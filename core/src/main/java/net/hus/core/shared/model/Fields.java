package net.hus.core.shared.model;

import java.util.ArrayList;
import java.util.List;

public class Fields extends AbstractModel
{
  private static final long serialVersionUID = -7554968452692353425L;

  private String mGroup; // FGG
  private String mName;
  private List<Field> mFields;

  private List<Long> mUnique;

  public String getName()
  {
    return mName;
  }

  public void setName(String inName)
  {
    mName = inName;
  }

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

  public Fields upsert(String inFgg, List<Long> inFieldIds)
  {
    List<Long> current = new ArrayList<>();
    for (Field value : mFields)
    {
      current.add(value.getId());
    }

    List<Field> change = new ArrayList<>();
    for (Long value : inFieldIds)
    {
      if (!current.contains(value))
      {
        change.add(new Field(value));
      }
    }
    Fields ret = new Fields();
    ret.fgg(inFgg);
    ret.setFields(change);

    return ret;
  }

  public Fields delete(String inFgg, List<Long> inFieldIds)
  {
    List<Field> change = new ArrayList<>();
    for (Field value : mFields)
    {
      if (!inFieldIds.contains(value.getId()))
      {
        change.add(value);
      }
    }

    Fields ret = new Fields();
    ret.fgg(inFgg);
    ret.setFields(change);
    return ret;
  }
}