package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.List;

import net.hus.core.shared.model.Field.Fid;

public class Values implements Serializable
{
  private static final long serialVersionUID = 1175600124812185604L;

  private Field mField;
  private List<Value> mValues;

  public List<Value> getValues()
  {
    return mValues;
  }

  public void setValues(List<Value> inValues)
  {
    mValues = inValues;
  }

  public Value get(Fid inFid)
  {
    // Value ret = null;
    // for (Value value : mValues)
    // {
    // if (inFid.fid().equals(value.getFid()))
    // {
    // ret = value;
    // break;
    // }
    // }
    return get(inFid.fid(), 0);
  }

  public Value get(Long inFid, int inPos)
  {
    Value ret = null;
    for (Value value : mValues)
    {
      if (inFid.equals(value.getFid()) && value.getPos() == inPos)
      {
        ret = value;
        break;
      }
    }
    return ret;
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