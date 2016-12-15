package net.hus.core.dao.jdbc.statement;

import java.sql.Types;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.statement.AbstractSqlJdbc.Statements;

public class MySqlTest
{
  @Test
  public void testGetStatements()
  {
    MySql mysql = new MySql();

    Statements stmts = mysql.getStatements("Fields.xml");

    int[] types = stmts.getStatement("UPSERT_FIELD").types();
    Assert.assertEquals(4, types.length);
    Assert.assertEquals(Types.VARCHAR, types[0]);
    Assert.assertEquals(Types.VARCHAR, types[1]);
    Assert.assertEquals(Types.VARCHAR, types[2]);
    Assert.assertEquals(Types.VARCHAR, types[3]);

    types = stmts.getStatement("SELECT_FIELD_BY_NAMETYPE").types();
    Assert.assertEquals(2, types.length);
    Assert.assertEquals(Types.VARCHAR, types[0]);
    Assert.assertEquals(Types.VARCHAR, types[1]);
  }
}
