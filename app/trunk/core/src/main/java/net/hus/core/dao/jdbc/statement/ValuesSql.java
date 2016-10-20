package net.hus.core.dao.jdbc.statement;

import javax.sql.DataSource;

public class ValuesSql extends AbstractSqlJdbc
{
  public ValuesSql()
  {
    mStmts = getStatements("Values.xml");
  }

  public ValuesSql(DataSource inDataSource)
  {
    this();
  }
}