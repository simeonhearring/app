package net.hus.core.model;

import java.util.Date;

public class Model
{
  private Long mId;
  private Date mCreated;
  private Date mUpdated;

  public Long getId()
  {
    return mId;
  }

  public void setId(Long inId)
  {
    mId = inId;
  }

  public Date getCreated()
  {
    return mCreated;
  }

  public void setCreated(Date inCreated)
  {
    mCreated = inCreated;
  }

  public Date getUpdated()
  {
    return mUpdated;
  }

  public void setUpdated(Date inUpdated)
  {
    mUpdated = inUpdated;
  }
}