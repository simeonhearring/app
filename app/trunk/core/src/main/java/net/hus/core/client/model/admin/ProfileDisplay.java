package net.hus.core.client.model.admin;

import java.util.List;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Profile;

public interface ProfileDisplay extends PageDisplay
{
  public interface Action
  {
    void select(String inValue);
  }

  void setAction(Action inAction);

  void addProfile(Profile inProfile);

  void addProfiles(List<Lookup> inProfiles);
}