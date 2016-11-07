package net.hus.core.dao.jdbc;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CoreJdbcTest extends MySqlCoreDsTest
{
  private CoreJdbc mJdbc;

  @Before
  public void before()
  {
    mJdbc = new CoreJdbc();
    mJdbc.setDataSource(mDataSource);
  }

  @Test
  public void test()
  {
    mJdbc.profile2lookup();
    Assert.assertTrue(true); // no fail
  }
}