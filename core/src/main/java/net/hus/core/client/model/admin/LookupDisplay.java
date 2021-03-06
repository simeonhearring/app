package net.hus.core.client.model.admin;

import java.util.List;

import net.hus.core.client.common.Display;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookups;

public interface LookupDisplay extends Display
{
  public interface Action
  {
    void select(String inValue);

    void createLookups(String inName);

    void createLookup(String inGroup, String inName, String inAbbr, int inSort);

    void saveLookups(String inName, String inDisplay);
  }

  void setAction(Action inAction);

  void setUp();

  void reset();

  void addValues(Lookups inLookups);

  void refreshLookupGroups();

  void clearLookupGroups();

  void addLookupGroups(String inType, List<Lookup> inLookupGroups);
}