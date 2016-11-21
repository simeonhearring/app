package net.hus.core.client.model.admin;

import java.util.List;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Lookup;

public interface FieldGroupsDisplay extends PageDisplay
{
  public interface Action
  {
    void select(String inFgg, String inName);

    void createGroup(String inName);

    void saveFields(String inFgg, String inName, List<Long> inFieldIds);

    void saveGroupName(String inFgg, String inName);

    void refresh();
  }

  void setAction(Action inAction);

  void addGroups(List<Lookup> inGroups);

  void addFields(List<Lookup> inFields);

  void selectFields(Fields inFields);

  void setGroupName(String inFgg, String inName);

  void reset();
}