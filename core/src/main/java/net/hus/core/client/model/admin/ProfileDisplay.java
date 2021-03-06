package net.hus.core.client.model.admin;

import java.util.List;

import net.hus.core.client.common.Display;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Profile;

public interface ProfileDisplay extends Display
{
  public interface Action
  {
    void select(String inValue);

    void saveProfile(String inFirst, String inMiddle, String inLast, String inPassword,
        String inPage, String inCss);

    void createProfile(String inUserName, String inFirst, String inLast, String inPage);
  }

  void setAction(Action inAction);

  void addProfile(Profile inProfile);

  void addProfiles(List<Lookup> inProfiles);

  void addPages(List<Lookup> inPages);

  void reset();
}