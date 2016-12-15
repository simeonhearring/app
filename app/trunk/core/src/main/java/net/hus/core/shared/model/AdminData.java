package net.hus.core.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminData implements Serializable
{
  private static final long serialVersionUID = 6775535535217948165L;

  private List<Lookup> mFields;
  private Field mField;

  private List<Lookup> mLookups;
  private Lookups mLookup;

  private List<Lookup> mFggs;
  private Fields mFgg;

  private List<Lookup> mProfiles;
  private Profile mProfile;

  private List<Lookup> mPages;
  private Components mPage;

  private List<Lookup> mCommands;

  private List<Lookup> mComponents;

  public void setFggs(List<Lookup> inFggs)
  {
    mFggs = inFggs;
  }

  public List<Lookup> getFggs()
  {
    return mFggs;
  }

  public void setFields(List<Lookup> inFields)
  {
    mFields = inFields;
  }

  public List<Lookup> getFields()
  {
    return mFields;
  }

  public void setField(Field inField)
  {
    mField = inField;
  }

  public Field getField()
  {
    return mField;
  }

  public Map<String, List<Lookup>> data()
  {
    Map<String, List<Lookup>> ret = new HashMap<>();

    for (Lookup value : mFields)
    {
      String key = value.getAbbreviation();
      if (!ret.containsKey(key))
      {
        ret.put(key, new ArrayList<Lookup>());
      }
      ret.get(key).add(value);
    }
    return ret;
  }

  public List<Lookup> getLookups()
  {
    return mLookups;
  }

  public void setLookups(List<Lookup> inLookups)
  {
    mLookups = inLookups;
  }

  public void setFgg(Fields inFgg)
  {
    mFgg = inFgg;
  }

  public Fields getFgg()
  {
    return mFgg;
  }

  public void setLookupGroup(Lookups inLookup)
  {
    mLookup = inLookup;
  }

  public Lookups getLookup()
  {
    return mLookup;
  }

  public void setProfile(Profile inProfile)
  {
    mProfile = inProfile;
  }

  public Profile getProfile()
  {
    return mProfile;
  }

  public List<Lookup> getProfiles()
  {
    return mProfiles;
  }

  public void setProfiles(List<Lookup> inProfiles)
  {
    mProfiles = inProfiles;
  }

  public void setPages(List<Lookup> inPages)
  {
    mPages = inPages;
  }

  public List<Lookup> getPages()
  {
    return mPages;
  }

  public void setPage(Components inPages)
  {
    mPage = inPages;
  }

  public Components getPage()
  {
    return mPage;
  }

  public void setCommands(List<Lookup> inCommands)
  {
    mCommands = inCommands;
  }

  public List<Lookup> getCommands()
  {
    return mCommands;
  }

  public String getDefaultFgg()
  {
    return mFggs.get(0).getName();
  }

  public Long getDefaultField()
  {
    return mFields.get(0).getAltId();
  }

  public List<Lookup> getComponents()
  {
    return mComponents;
  }

  public void setComponents(List<Lookup> inComponents)
  {
    mComponents = inComponents;
  }
}