package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;
import net.hus.core.shared.model.Lookup;

public class LookupSqlTest extends MySqlCoreDsTest
{
  private LookupSql mSql;

  @Before
  public void before()
  {
    mSql = new LookupSql(mDataSource);
  }

  @Test
  @Ignore
  public void testUpsertAndSelect()
  {
    String text = "PROFILE_" + System.currentTimeMillis();

    Lookup model = new Lookup();
    model.setGroup(VALUE_TABLE);
    model.setName(VALUE_KEY);
    model.setXL(text);

    List<Lookup> list = new ArrayList<>();
    list.add(model);

    mSql.upsertXL(list);

    Lookup result = mSql.selectXL(VALUE_TABLE, VALUE_KEY);
    Assert.assertEquals(text, result.getXL());

    List<Lookup> results = mSql.selectXL(VALUE_TABLE);
    Assert.assertEquals(1, results.size());
  }

  @Test
  @Ignore
  public void testSelecGroups()
  {
    List<String> results = mSql.selectGrps();
    Assert.assertEquals(true, results.size() > 5);
  }
}