package net.hus.core.shared.model;

import java.util.Date;

public interface Model
{
  Long getId();

  void setId(Long inId);

  Date getCreated();

  void setCreated(Date inCreated);

  Date getUpdated();

  void setUpdated(Date inUpdated);
}