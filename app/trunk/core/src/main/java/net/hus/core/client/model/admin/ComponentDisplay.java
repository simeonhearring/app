package net.hus.core.client.model.admin;

import java.util.List;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.Lookup;

public interface ComponentDisplay extends PageDisplay
{
  public interface Action
  {
    void selectPage(String inName);

    void createPage(String inName, String inFvt, String inFgg, String inPage);

    void savePage(String inDisplay);

    void savePage(String inFvt, String inFgg, String inPage);

    void selectComponent(int inNodeId);
  }

  void setAction(Action inAction);

  void addPages(List<Lookup> inPages);

  void addPage(Components inPage);

  void addFieldGroups(List<Lookup> inFieldGroups);

  void addTables(List<Lookup> inTables);
}