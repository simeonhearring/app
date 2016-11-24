package net.hus.core.dao;

import net.hus.core.dao.jdbc.statement.FieldsSql;
import net.hus.core.dao.jdbc.statement.LookupSql;
import net.hus.core.dao.jdbc.statement.ValuesSql;
import net.hus.core.shared.model.AppProfile;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.LookupXL;
import net.hus.core.shared.model.Profile;

public interface CoreDao
{
  FieldsSql fields();

  ValuesSql values();

  LookupSql lookups();

  Profile profile(String inName);

  AppProfile profile_app(String inName);

  Components components(String inComponentName);

  void field2lookup();

  void fields2lookup();

  void profile2lookup();

  void components2lookup();

  void upsertXL(LookupXL inLookupXL);
}