package net.hus.core.dao;

import net.hus.core.dao.jdbc.statement.FieldsSql;
import net.hus.core.dao.jdbc.statement.LookupSql;
import net.hus.core.dao.jdbc.statement.ValuesSql;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.LookupXL;
import net.hus.core.shared.model.Profile;

public interface CoreDao
{
  FieldsSql fields();

  ValuesSql values();

  LookupSql lookups();

  Profile profile(String inName);

  Components components(String inName);

  Fields fields(String inFgg);

  void field2lookup();

  void profile2lookup();

  void table2lookup();

  void components2lookup();

  void upsertXL(LookupXL inLookupXL);
}