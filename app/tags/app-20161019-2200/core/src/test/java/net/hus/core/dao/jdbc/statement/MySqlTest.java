package net.hus.core.dao.jdbc.statement;

import java.sql.Types;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.statement.AbstractSqlJdbc.Statements;

public class MySqlTest
{
  @Test
  public void testToStatements()
  {
    MySql mysql = new MySql();

    Statements stmts = mysql.getStatements("Profile.xml");

    int[] types = stmts.getStatement("UPSERT").types();
    Assert.assertEquals(4, types.length);
    Assert.assertEquals(Types.VARCHAR, types[0]);
    Assert.assertEquals(Types.VARCHAR, types[1]);
    Assert.assertEquals(Types.VARCHAR, types[2]);
    Assert.assertEquals(Types.VARCHAR, types[3]);

    types = stmts.getStatement("SELECT").types();
    Assert.assertEquals(2, types.length);
    Assert.assertEquals(Types.VARCHAR, types[0]);
    Assert.assertEquals(Types.VARCHAR, types[1]);
  }
}
