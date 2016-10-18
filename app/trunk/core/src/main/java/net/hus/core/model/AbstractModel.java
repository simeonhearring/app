package net.hus.core.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public abstract class AbstractModel implements Model, Serializable
{
  private Long mId;
  private Date mCreated;
  private Date mUpdated;

  private boolean mDelete;
  private boolean mDirty;

  public String value()
  {
    return String.valueOf(mId);
  }

  public static <M extends AbstractModel> void arrange(Collection<M> inList, List<M> inInsert,
      List<M> inUpdate)
  {
    for (M value : inList)
    {
      if (value.isDirty())
      {
        if (value.isNew())
        {
          inInsert.add(value);
        }
        else
        {
          inUpdate.add(value);
        }
      }
    }
  }

  public boolean isDelete()
  {
    return mDelete;
  }

  public void setDelete(boolean inDelete)
  {
    mDelete = inDelete;
  }

  public boolean isNew()
  {
    return mId == null;
  }

  public void setDirty(boolean inDirty)
  {
    mDirty = inDirty;
  }

  public boolean isDirty()
  {
    return mDirty;
  }

  @Override
  public Long getId()
  {
    return mId;
  }

  @Override
  public void setId(Long inId)
  {
    mId = inId;
  }

  @Override
  public Date getCreated()
  {
    return mCreated;
  }

  @Override
  public void setCreated(Date inCreated)
  {
    mCreated = inCreated;
  }

  @Override
  public Date getUpdated()
  {
    return mUpdated;
  }

  @Override
  public void setUpdated(Date inUpdated)
  {
    mUpdated = inUpdated;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + (mId == null ? 0 : mId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    AbstractModel other = (AbstractModel) obj;
    if (mId == null)
    {
      if (other.mId != null)
      {
        return false;
      }
    }
    else if (!mId.equals(other.mId))
    {
      return false;
    }
    return true;
  }
}