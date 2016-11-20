package net.hus.core.client.model.admin;

import net.hus.core.client.common.PageDisplay;

public interface FieldGroupsDisplay extends PageDisplay
{
  public interface Action
  {
  }

  void setAction(Action inAction);
}