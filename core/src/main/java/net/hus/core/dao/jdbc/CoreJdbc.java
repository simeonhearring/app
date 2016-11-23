package net.hus.core.dao.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import net.hus.core.dao.CoreDao;
import net.hus.core.dao.jdbc.statement.FieldsSql;
import net.hus.core.dao.jdbc.statement.LookupSql;
import net.hus.core.dao.jdbc.statement.ValuesSql;
import net.hus.core.parser.AppProfileParser;
import net.hus.core.parser.ComponentsParser;
import net.hus.core.parser.Parser;
import net.hus.core.parser.ProfileParser;
import net.hus.core.shared.components.Components;
import net.hus.core.shared.components.Components.Type;
import net.hus.core.shared.model.AppProfile;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.model.Profile;
import net.hus.core.shared.util.StringUtil;

public class CoreJdbc implements CoreDao
{
  private FieldsSql mFields;
  private LookupSql mLookups;
  private ValuesSql mValues;

  private ProfileParser mProfileParser;
  private AppProfileParser mAppProfileParser;
  private ComponentsParser mComponentsParser;

  public void setDataSource(DataSource inDataSource)
  {
    mFields = new FieldsSql(inDataSource);
    mLookups = new LookupSql(inDataSource);
    mValues = new ValuesSql(inDataSource);

    mAppProfileParser = new AppProfileParser();
    mProfileParser = new ProfileParser();
    mComponentsParser = new ComponentsParser();
  }

  @Override
  public FieldsSql fields()
  {
    return mFields;
  }

  @Override
  public LookupSql lookups()
  {
    return mLookups;
  }

  @Override
  public ValuesSql values()
  {
    return mValues;
  }

  private <M> M parse(Parser<M> inParser, String inXml)
  {
    M ret = null;

    if (inXml != null)
    {
      ret = inParser.fromXml(inXml);
    }

    return ret;
  }

  private <M> String toXml(Parser<M> inParser, M inObj)
  {
    String ret = null;

    if (inObj != null)
    {
      ret = inParser.toXml(inObj);
    }

    return ret;
  }

  public void upsertXL(List<Lookup> inLookups, Object inObj)
  {
    for (Lookup value : inLookups)
    {
      Group group = value.group();
      if (Group.isXL(group))
      {
        Parser<?> parser = parser(group);
        // String xml = toXml(parser, inObj);
      }
    }
  }

  private Parser<?> parser(Group inGroup)
  {
    Parser<?> ret = null;
    switch (inGroup)
    {
      case APP_PROFILE:
        ret = mAppProfileParser;
        break;
      case PROFILE:
        ret = mProfileParser;
        break;
      case COMPONENTS:
        ret = mComponentsParser;
        break;
      default:
        break;
    }
    return ret;
  }

  @Override
  public AppProfile profile_app(String inName)
  {
    String xml = lookups().selectXL(Group.APP_PROFILE, inName).getXL();
    return parse(mAppProfileParser, xml);
  }

  @Override
  public Profile profile(String inName)
  {
    Lookup lookup = lookups().selectXL(Group.PROFILE, inName);
    String xml = lookup.getXL();
    Profile ret = parse(mProfileParser, xml);
    ret.setCreated(lookup.getCreated());
    ret.setUpdated(lookup.getUpdated());
    ret.setId(lookup.getId());
    return ret;
  }

  @Override
  public Components components(String inComponentName)
  {
    String xml = lookups().selectXL(Group.COMPONENTS, inComponentName).getXL();
    return parse(mComponentsParser, xml);
  }

  public void component2lookup()
  {
    List<Lookup> lookups = new ArrayList<>();
    for (Type value : Components.Type.values())
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.COMPONENT);
      lookup.setName(value.name());

      lookup.setAltId(null);
      lookup.setDisplay(value.display());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  public void profile2lookup()
  {
    List<Profile> profiles = new ArrayList<>();
    for (Lookup value : lookups().selectXL(Group.PROFILE.name()))
    {
      profiles.add(parse(mProfileParser, value.getXL()));
    }

    List<Lookup> lookups = new ArrayList<>();
    for (Profile value : profiles)
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.PROFILE);
      lookup.setName(value.getUserName());

      lookup.setAltId(value.getId());
      lookup.setDisplay(value.getName());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  // TODO
  public void appprofile2lookup()
  {
    List<Profile> profiles = new ArrayList<>();
    for (Lookup value : lookups().selectXL(Group.APP_PROFILE.name()))
    {
      profiles.add(parse(mProfileParser, value.getXL()));
    }

    List<Lookup> lookups = new ArrayList<>();
    for (Profile value : profiles)
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.APP_PROFILE);
      lookup.setName(value.getUserName());

      lookup.setAltId(value.getId());
      lookup.setDisplay(value.getName());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  public void components2lookup()
  {
    List<Lookup> lookups = new ArrayList<>();
    for (Lookup value : lookups().selectXL(Group.COMPONENTS.name()))
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.COMPONENTS);
      lookup.setName(value.getName());

      lookup.setAltId(value.getId());
      lookup.setDisplay(value.getDisplay());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  public void lookup2lookup()
  {
    List<Lookup> lookups = new ArrayList<>();
    for (String value : lookups().selectGrps())
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.LOOKUP);
      lookup.setName(value);

      lookup.setAltId(null);
      lookup.setDisplay(StringUtil.toTitle(value.replaceAll("_", " ")));
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  @Override
  public void field2lookup()
  {
    List<Lookup> lookups = new ArrayList<>();
    for (Field value : fields().select())
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.FIELD);
      lookup.setName(value.getName());

      lookup.setAltId(value.getId());
      lookup.setDisplay(value.getProperties().getDisplay().getLong());
      lookup.setAbbreviation(value.getType().name());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  @Override
  public void fields2lookup()
  {
    Map<String, StringBuilder> data = new HashMap<>();
    Map<String, String> data2 = new HashMap<>();
    for (Object[] value : fields().selectGrp())
    {
      String grp = (String) value[0];
      Long id = (Long) value[1];

      if (!data.containsKey(grp))
      {
        data2.put(grp, (String) value[2]);
        data.put(grp, new StringBuilder());
      }
      data.get(grp).append(id).append(",");
    }

    List<Lookup> lookups = new ArrayList<>();
    for (Entry<String, StringBuilder> value : data.entrySet())
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.FIELD_GROUP);
      lookup.setName(value.getKey());

      lookup.setDisplay(data2.get(value.getKey()));
      lookup.setAltId(null);
      lookup.setAbbreviation(null);
      lookup.setDescription(value.getValue().toString());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }
}