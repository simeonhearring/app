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

    void addComponent(Components.Type inComponent);

    void remove();

    void refreshComponent();
  }

  void setAction(Action inAction);

  void addPages(List<Lookup> inPages);

  void addPage(Components inPage);

  void addFieldGroups(List<Lookup> inFggs);

  void addComponents(List<Lookup> inComponents);

  void addTables(List<Lookup> inFvts);

  void addComponent(IsWidget inDisplay);

  IsWidget getDisplay(UIObject_ inUIObject, Fields inFields, boolean inChild, Page.Layout inPage);

  void reset();

  void showAdd(boolean inAllow);
}