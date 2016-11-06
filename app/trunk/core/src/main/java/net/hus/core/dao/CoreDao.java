package net.hus.core.dao;

import net.hus.core.dao.jdbc.statement.FieldsSql;
import net.hus.core.dao.jdbc.statement.LookupSql;
import net.hus.core.dao.jdbc.statement.ValuesSql;
import net.hus.core.model.Profile;
import net.hus.core.shared.components.Components;

public interface CoreDao
{
  FieldsSql fields();

  ValuesSql values();

  LookupSql lookups();

  Profile profile(String inName);

  Profile profile_app(String inName);

  Components components(String inComponentName);
}