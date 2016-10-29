package net.hus.core.dao;

import net.hus.core.dao.jdbc.statement.FieldsSql;
import net.hus.core.dao.jdbc.statement.LookupSql;
import net.hus.core.dao.jdbc.statement.ValuesSql;

public interface CoreDao
{
  ValuesSql values();

  LookupSql lookups();

  FieldsSql fields();
}