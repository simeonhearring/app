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
import net.hus.core.shared.model.AppProfile;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.model.Profile;

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

  @Override
  public AppProfile profile_app(String inName)
  {
    String xml = lookups().selectXL(Group.APP_PROFILE, inName).getXL();
    return parse(mAppProfileParser, xml);
  }

  @Override
  public Profile profile(String inName)
  {
    String xml = lookups().selectXL(Group.PROFILE, inName).getXL();
    return parse(mProfileParser, xml);
  }

  @Override
  public Components components(String inComponentName)
  {
    String xml = lookups().selectXL(Group.COMPONENTS, inComponentName).getXL();
    return parse(mComponentsParser, xml);
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
      lookup.setAltId(value.getId());
      lookup.setName(value.getUserName());
      lookup.setAbbreviation(value.getName());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  public void field2lookup()
  {
    List<Lookup> lookups = new ArrayList<>();
    for (Field value : fields().select())
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.FIELD);
      lookup.setAltId(value.getId());
      lookup.setName(value.getName());
      lookup.setAbbreviation(value.getType().name());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  public void fields2lookup()
  {
    Map<String, StringBuilder> data = new HashMap<>();
    for (Object[] value : fields().selectGrp())
    {
      String grp = (String) value[0];
      Long id = (Long) value[1];

      if (!data.containsKey(grp))
      {
        data.put(grp, new StringBuilder());
      }
      data.get(grp).append(id).append(",");
    }

    List<Lookup> lookups = new ArrayList<>();
    for (Entry<String, StringBuilder> value : data.entrySet())
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.FIELD_GROUP);
      lookup.setAltId(null);
      lookup.setName(value.getKey());
      lookup.setAbbreviation(value.getValue().toString());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }
}