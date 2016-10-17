package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;
import net.hus.core.model.Field;
import net.hus.core.model.Field.Properties;
import net.hus.core.model.Field.Type;
import net.hus.core.model.Fields;

public class FieldSqlTest extends MySqlCoreDsTest
{
  private FieldsSql mSql;

  @Before
  public void before()
  {
    mSql = new FieldsSql(mDataSource);
  }

  @Test
  public void testUpsertAndSelectField()
  {
    Field f1 = new Field();
    f1.setName("FIRST_NAME");
    f1.setType(Type.STRING);
    f1.setProperties(new Properties());

    Field f2 = new Field();
    f2.setName("LAST_NAME");
    f2.setType(Type.STRING);
    f2.setProperties(new Properties());

    Field f3 = new Field();
    f3.setName("MIDDLE_NAME");
    f3.setType(Type.STRING);
    f3.setProperties(new Properties());

    List<Field> list = new ArrayList<>();
    list.add(f1);
    list.add(f2);
    list.add(f3);

    mSql.upsert(list);

    Field field = mSql.select("FIRST_NAME", Type.STRING);

    Assert.assertEquals(true, field.getProperties() != null);
    Assert.assertEquals(null, field.getProperties().getDisplay());
  }

  @Test
  public void testUpsertAndSelectFields()
  {
    Fields fields = new Fields();
    fields.setFields(new ArrayList<Field>());

    Field f1 = new Field();
    f1.setId(1L);
    f1.setSort(1);
    Field f2 = new Field();
    f2.setId(2L);
    f2.setSort(2);
    Field f3 = new Field();
    f3.setId(3L);
    f3.setSort(3);

    fields.setGroup("SAMPLE");
    fields.add(f1);
    fields.add(f2);
    fields.add(f3);

    mSql.upsert(fields);

    Fields ret = mSql.select("SAMPLE");
    Assert.assertEquals(3, ret.getFields().size());
  }
}