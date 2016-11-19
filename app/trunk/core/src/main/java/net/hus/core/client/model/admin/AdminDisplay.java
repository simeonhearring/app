package net.hus.core.client.model.admin;

import net.hus.core.client.common.PageDisplay;

public interface AdminDisplay extends PageDisplay
{
  public interface Action
  {
  }

  public void setAction(Action inAction);

  FieldsDisplay getFields();
}