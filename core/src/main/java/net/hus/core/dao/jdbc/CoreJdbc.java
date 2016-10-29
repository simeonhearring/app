package net.hus.core.dao.jdbc;

import javax.sql.DataSource;

import net.hus.core.dao.CoreDao;
import net.hus.core.dao.jdbc.statement.FieldsSql;
import net.hus.core.dao.jdbc.statement.LookupSql;
import net.hus.core.dao.jdbc.statement.ValuesSql;

public class CoreJdbc implements CoreDao
{
  private FieldsSql mFields;
  private LookupSql mLookups;
  private ValuesSql mValues;

  public void setDataSource(DataSource inDataSource)
  {
    mFields = new FieldsSql(inDataSource);
    mLookups = new LookupSql(inDataSource);
    mValues = new ValuesSql(inDataSource);
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
}