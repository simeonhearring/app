package net.hus.core.dao.jdbc.statement;

import java.sql.Types;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.statement.AbstractSqlJdbc.Sql;

public class MySqlTest
{
  @Test
  public void test()
  {
    MySql mysql = new MySql();

    Sql sql = mysql.getSqlObj("ProfileUpsert.xml");

    int[] types = sql.getTypes();
    Assert.assertEquals(4, types.length);
    Assert.assertEquals(Types.VARCHAR, types[0]);
    Assert.assertEquals(Types.VARCHAR, types[1]);
    Assert.assertEquals(Types.VARCHAR, types[2]);
    Assert.assertEquals(Types.VARCHAR, types[3]);
  }
}
