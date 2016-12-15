package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.Fid;
import net.hus.core.shared.model.Value;
import net.hus.core.shared.model.Values;

public class ValuesSqlTest extends MySqlCoreDsTest
{
  private ValuesSql mSql;

  @Before
  public void before()
  {
    mSql = new ValuesSql(mDataSource);
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
    value.setField(new Field(Fid.FIRST_NAME.fid()));
    Date asOf = new Date();
    value.setAsOf(asOf);

    list.add(value);

    mSql.insert(list);

    Values values = new Values();
    values.setValues(mSql.selectLast(TK));

    Value v1 = values.get(Fid.FIRST_NAME);

    String expected = String.valueOf(asOf.getTime()).substring(0, 10);
    String actual = String.valueOf(v1.getAsOf().getTime()).substring(0, 10);
    Assert.assertEquals(expected, actual);

    values.setValues(mSql.selectLastPos(TK));

    v1 = values.get(Fid.FIRST_NAME);

    expected = String.valueOf(asOf.getTime()).substring(0, 10);
    actual = String.valueOf(v1.getAsOf().getTime()).substring(0, 10);
    Assert.assertEquals(expected, actual);
  }
}