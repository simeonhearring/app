package net.hus.core.dao.jdbc;

import javax.sql.DataSource;

import net.hus.core.dao.CoreDao;
import net.hus.core.dao.jdbc.statement.FieldsSql;
import net.hus.core.dao.jdbc.statement.LookupSql;
import net.hus.core.dao.jdbc.statement.ValuesSql;
import net.hus.core.model.Lookup.Group;
import net.hus.core.model.Profile;
import net.hus.core.parser.ComponentsParser;
import net.hus.core.parser.Parser;
import net.hus.core.parser.ProfileParser;
import net.hus.core.shared.model.Components;

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
  public Profile profile_app(String inName)
  {
    String xml = lookups().selectXL(Group.APP_PROFILE, inName).getXL();
    return parse(mProfileParser, xml);
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
}