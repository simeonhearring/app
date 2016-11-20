package net.hus.core.client.model.admin;

import java.util.List;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Lookup;

public interface FieldGroupsDisplay extends PageDisplay
{
  public interface Action
  {
    void select(String inGroup, String inDisplay, Long inId);

    void addGroup(String inGroup);
  }

  void setAction(Action inAction);

  void addGroups(List<Lookup> inFieldGroups);

  void addFields(List<Lookup> inFields);

  void addFieldGroup(Fields inFieldGroup);

  void setGroupName(String inGroup, String inDisplay);
}