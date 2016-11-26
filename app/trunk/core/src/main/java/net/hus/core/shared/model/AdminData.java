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

  private List<Lookup> mLookupGroups;// TODO should be Lookups
  private Lookups mLookups;

  private List<Lookup> mFieldGroups;
  private Fields mFieldGroup;

  private List<Lookup> mProfiles;
  private Profile mProfile;

  private List<Lookup> mPages;
  private Components mPage;

  private List<Lookup> mTables;

  private List<Lookup> mCommands;

  public void setFieldGroups(List<Lookup> inFieldGroups)
  {
    mFieldGroups = inFieldGroups;
  }

  public List<Lookup> getFieldGroups()
  {
    return mFieldGroups;
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

  public List<Lookup> getLookupGroups()
  {
    return mLookupGroups;
  }

  public void setLookupGroups(List<Lookup> inLookupGroups)
  {
    mLookupGroups = inLookupGroups;
  }

  public void setFieldGroup(Fields inFields)
  {
    mFieldGroup = inFields;
  }

  public Fields getFieldGroup()
  {
    return mFieldGroup;
  }

  public void setLookupGroup(Lookups inLookups)
  {
    mLookups = inLookups;
  }

  public Lookups getLookups()
  {
    return mLookups;
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

  public List<Lookup> getTables()
  {
    return mTables;
  }

  public void setTables(List<Lookup> inTables)
  {
    mTables = inTables;
  }

  public void setCommands(List<Lookup> inCommands)
  {
    mCommands = inCommands;
  }

  public List<Lookup> getCommands()
  {
    return mCommands;
  }

  public String getDefaultFieldGroup()
  {
    return mFieldGroups.get(0).getName();
  }

  public String getDefaultLookupGroup()
  {
    return mLookupGroups.get(0).getName();
  }

  public Long getDefaultField()
  {
    return mFields.get(0).getAltId();
  }
}