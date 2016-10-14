package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;

public class ProfileSqlTest extends MySqlCoreDsTest
{
  private ProfileSql mSql;

  @Before
  public void before()
  {
    mSql = new ProfileSql(mDataSource);
  }

  @Test
  public void testUpsertAndSelect()
  {
    String org = "HUS";
    String name = "JUNIT";
    String text = "PROFILE_" + System.currentTimeMillis();

    List<String[]> profile = new ArrayList<>();
    profile.add(new String[]
    {
        org,
        name,
        text
    });
    mSql.upsert(profile);

    String results = mSql.select(org, name);
    Assert.assertEquals(text, results);
  }
}