package net.hus.core.client.model.admin;

import net.hus.core.client.common.PageDisplay;

public interface AdminDisplay extends PageDisplay
{
  FieldDisplay getField();

  FieldsDisplay getFields();
}