package net.hus.core.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import net.hus.core.dao.CoreDao;
import net.hus.core.dao.jdbc.statement.FieldsSql;
import net.hus.core.dao.jdbc.statement.LookupSql;
import net.hus.core.dao.jdbc.statement.ValuesSql;
import net.hus.core.parser.ComponentsParser;
import net.hus.core.parser.Parser;
import net.hus.core.parser.ProfileParser;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.Components.Type;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.model.LookupXL;
import net.hus.core.shared.model.Lookups;
import net.hus.core.shared.model.Profile;
import net.hus.core.shared.util.StringUtil;

public class CoreJdbc implements CoreDao
{
  private FieldsSql mFields;
  private LookupSql mLookups;
  private ValuesSql mValues;

  private ProfileParser mProfileParser;
  private ComponentsParser mComponentsParser;

  public void setDataSource(DataSource inDataSource)
  {
    mFields = new FieldsSql(inDataSource);
    mLookups = new LookupSql(inDataSource);
    mValues = new ValuesSql(inDataSource);

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
  public void upsertXL(LookupXL inLookupXL)
  {
    Lookup lookUp = new Lookup();
    lookUp.setGroup(inLookupXL.groupXL());
    lookUp.setCode(inLookupXL.nameXL());
    lookUp.setName(inLookupXL.displayXL());
    lookUp.setXL(toXml(inLookupXL));

    List<Lookup> list = new ArrayList<>();
    list.add(lookUp);

    lookups().upsertXL(list);
  }

  private String toXml(LookupXL inLookupXL)
  {
    String ret = null;
    switch (inLookupXL.groupXL())
    {
      case PROFILE:
        ret = mProfileParser.toXml((Profile) inLookupXL);
        break;
      case COMPONENTS:
        ret = mComponentsParser.toXml((Components) inLookupXL);
        break;
      default:
        break;
    }
    return ret;
  }

  @Override
  public Profile profile(String inName)
  {
    Lookup lookup = lookups().selectXL(Group.PROFILE, inName);
    Profile ret = parse(mProfileParser, lookup.getXL());
    ret.setCreated(lookup.getCreated());
    ret.setUpdated(lookup.getUpdated());
    ret.setId(lookup.getId());
    return ret;
  }

  @Override
  public Components components(String inComponentName)
  {
    Lookup lookup = lookups().selectXL(Group.COMPONENTS, inComponentName);
    Components ret = parse(mComponentsParser, lookup.getXL());
    ret.setCreated(lookup.getCreated());
    ret.setUpdated(lookup.getUpdated());
    ret.setId(lookup.getId());
    ret.setName(lookup.getCode());
    ret.setDisplay(lookup.getName());
    return ret;
  }

  @Override
  public Fields fields(String inFgg)
  {
    Lookups lookup = lookups().select(Group.TABLE.name(), inFgg);

    Fields ret = new Fields();
    ret.fgg(lookup.getCode());
    ret.setName(lookup.getName());
    ret.setCreated(lookup.getCreated());
    ret.setUpdated(lookup.getUpdated());
    ret.setId(lookup.getId());
    ret.setFields(fields().selectByFgg(inFgg));

    return ret;
  }

  public void component2lookup()
  {
    List<Lookup> lookups = new ArrayList<>();
    for (Type value : Components.Type.values())
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.COMPONENT);
      lookup.setCode(value.name());

      lookup.setAltId(null);
      lookup.setName(value.display());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  @Override
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
      lookup.setCode(value.getUserName());

      lookup.setAltId(value.getId());
      lookup.setName(value.getName());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  @Override
  public void components2lookup()
  {
    List<Lookup> lookups = new ArrayList<>();
    for (Lookup value : lookups().selectXL(Group.COMPONENTS.name()))
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.COMPONENTS);
      lookup.setCode(value.getCode());

      lookup.setAltId(value.getId());
      lookup.setName(value.getName());
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
      lookup.setCode(value);

      lookup.setAltId(null);
      lookup.setName(StringUtil.toTitle(value.replaceAll("_", " ")));
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
      lookup.setCode(value.getCode());

      lookup.setAltId(value.getId());
      lookup.setName(value.getProperties().getDisplay().getLong());
      lookup.setAbbreviation(value.getType().name());
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }

  @Override
  public void table2lookup()
  {
    List<Lookup> lookups = new ArrayList<>();
    for (String value : fields().selectTables())
    {
      Lookup lookup = new Lookup();
      lookup.setGroup(Group.TABLE);
      lookup.setCode(value);
      lookup.setName(StringUtil.toTitle(value));
      lookup.setSort(0);
      lookups.add(lookup);
    }
    lookups().upsert(lookups);
  }
}