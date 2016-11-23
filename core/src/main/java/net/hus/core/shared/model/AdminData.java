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

  private List<Lookup> mLookupGroups;

  private List<Lookup> mFieldGroups;

  private Fields mFieldGroup;

  private Field mField;

  private Lookups mLookups;

  private Profile mProfile;

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

  // public boolean exists(String inName)
  // {
  // private List<String> mUnique;
  //
  // if (mUnique == null)
  // {
  // mUnique = new ArrayList<>();
  // for (Lookup value : mFields)
  // {
  // mUnique.add(value.getName());
  // }
  // }
  //
  // return mUnique.contains(Field.officialName(inName));
  // }

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
}