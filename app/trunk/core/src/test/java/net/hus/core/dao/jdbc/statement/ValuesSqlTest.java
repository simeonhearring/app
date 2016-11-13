package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Value;

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
    List<Value> i = mSql.select(TK);
    Assert.assertEquals(VALUE_TABLE, i.get(0).getFieldTKG().getFvt());
    Assert.assertEquals(VALUE_KEY, i.get(0).getFieldTKG().getFvk());
  }

  @Test
  public void testSelectKeyField()
  {
    List<Value> i = mSql.select(TK, 1L);
    Assert.assertEquals(VALUE_TABLE, i.get(0).getFieldTKG().getFvt());
    Assert.assertEquals(VALUE_KEY, i.get(0).getFieldTKG().getFvk());
  }

  @Test
  public void testSelectLastKey()
  {
    List<Value> i = mSql.selectLast(TK);
    Assert.assertEquals(VALUE_TABLE, i.get(0).getFieldTKG().getFvt());
    Assert.assertEquals(VALUE_KEY, i.get(0).getFieldTKG().getFvk());
  }

  @Test
  public void testInsert()
  {
    List<Value> list = new ArrayList<>();

    Value value = new Value();
    value.setFieldTKG(TK);
    value.setValue("Simeon-JUNIT");
    value.setValueId(-1L);
    value.setField(new Field());
    value.getField().setId(1L);
    Date asOf = new Date();
    value.setAsOf(asOf);

    list.add(value);

    mSql.insert(list);

    List<Value> results = mSql.select(TK, 1L);
    String expected = String.valueOf(asOf.getTime()).substring(0, 10);
    String actual = String.valueOf(results.get(0).getAsOf().getTime()).substring(0, 10);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testUpdate()
  {
    List<Value> list = new ArrayList<>();

    Value value = new Value();
    value.setFieldTKG(TK);
    value.setField(new Field());
    value.getField().setId(1L);
    Date asOf = new Date();
    value.setAsOf(asOf);

    value.setValue("Simeon-JUNIT--");

    list.add(value);

    mSql.update(list);
  }
}