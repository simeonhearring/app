package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;
import net.hus.core.model.Field;
import net.hus.core.model.Value;

public class ValuesSqlTest extends MySqlCoreDsTest
{
  private ValuesSql mSql;

  @Before
  public void before()
  {
    mSql = new ValuesSql(mDataSource);
  }

  @Test
  public void testSelectKey()
  {
    List<Value> i = mSql.select(VALUE_KEY);
    Assert.assertEquals(VALUE_KEY, i.get(0).getKey());
  }

  @Test
  public void testSelectKeyField()
  {
    List<Value> i = mSql.select(VALUE_KEY, 1L);
    Assert.assertEquals(VALUE_KEY, i.get(0).getKey());
  }

  @Test
  public void testSelectLastKey()
  {
    List<Value> i = mSql.selectLast(VALUE_KEY);
    Assert.assertEquals(3, i.size());
    Assert.assertEquals(VALUE_KEY, i.get(0).getKey());
  }

  @Test
  public void testInsert()
  {
    List<Value> list = new ArrayList<>();

    Value value = new Value();
    value.setKey(VALUE_KEY);
    value.setValue("1");
    value.setField(new Field());
    value.getField().setId(1L);
    Date asOf = new Date();
    value.setAsOf(asOf);

    list.add(value);

    mSql.insert(list);

    List<Value> results = mSql.select(VALUE_KEY, 1L);
    String expected = String.valueOf(asOf.getTime()).substring(0, 10);
    String actual = String.valueOf(results.get(0).getAsOf().getTime()).substring(0, 10);
    Assert.assertEquals(expected, actual);
  }
}