package net.hus.core.shared.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.hus.core.shared.model.AbstractModel;

@SuppressWarnings("serial")
public abstract class AbstractSaveCommand<M extends AbstractModel> extends AbstractCommand
{
  private List<M> mInsert;
  private List<M> mUpdate;
  private List<M> mDelete;

  public AbstractSaveCommand()
  {
  }

  public AbstractSaveCommand(Collection<M> inList)
  {
    arrange(inList);
  }

  public AbstractSaveCommand(List<M> inInsert, List<M> inUpdate, List<M> inDelete)
  {
    mInsert = inInsert;
    mUpdate = inUpdate;
    mDelete = inDelete;
  }

  public List<M> getInsert()
  {
    return mInsert;
  }

  public List<M> getUpdate()
  {
    return mUpdate;
  }

  public List<M> getDelete()
  {
    return mDelete;
  }

  private void arrange(Collection<M> inList)
  {
    mInsert = new ArrayList<>();
    mUpdate = new ArrayList<>();
    mDelete = new ArrayList<>();

    for (M value : inList)
    {
      if (value.isDelete())
      {
        mDelete.add(value);
      }
      else if (value.isDirty())
      {
        if (value.isNew())
        {
          mInsert.add(value);
        }
        else
        {
          mUpdate.add(value);
        }
      }
    }
  }

  public boolean hasChange()
  {
    int c = size(mInsert);
    c += size(mUpdate);
    c += size(mDelete);
    return c > 0;
  }

  private static int size(List<?> inList)
  {
    return inList != null ? inList.size() : 0;
  }
}