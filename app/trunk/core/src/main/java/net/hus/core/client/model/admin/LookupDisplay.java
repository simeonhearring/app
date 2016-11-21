package net.hus.core.client.model.admin;

import java.util.List;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.shared.model.Lookup;

public interface LookupDisplay extends PageDisplay
{
  public interface Action
  {
    void select(String inValue);
  }

  void setAction(Action inAction);

  void addLookupGroups(List<Lookup> inLookupGroups);

  void addValues(List<Lookup> inLookupGroup);
}