package net.hus.core.client.model.admin;

import net.hus.core.client.common.PageDisplay;

public interface AdminDisplay extends PageDisplay
{
  FieldsDisplay getFields();

  FieldGroupsDisplay getGroups();
}