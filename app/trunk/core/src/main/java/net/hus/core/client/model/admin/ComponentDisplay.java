package net.hus.core.client.model.admin;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.common.Display;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.UIObject_;

public interface ComponentDisplay extends Display
{
  public interface Action
  {
    void selectPage(String inName);

    void createPage(String inName, String inFvt, String inFgg, String inPage);

    void savePage();

    void savePage(String inDisplay);

    void savePage(String inFvt, String inFgg, String inPage);

    void selectComponent(int inNodeId, int inParentId);

    void refresh();
  }

  void setAction(Action inAction);

  void addPages(List<Lookup> inPages);

  void addPage(Components inPage);

  void addFieldGroups(List<Lookup> inFieldGroups);

  void addTables(List<Lookup> inTables);

  void addComponent(IsWidget inDisplay);

  IsWidget getDisplay(UIObject_ inUIObject, Fields inFields, boolean inChild, Page.Name inPage);

  void reset();
}