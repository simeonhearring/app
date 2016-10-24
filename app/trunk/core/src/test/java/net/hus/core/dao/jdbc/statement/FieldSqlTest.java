package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;
import net.hus.core.model.Field;
import net.hus.core.model.Field.Display;
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
    Field f1 = newField(Type.STRING, "FIRST_NAME", "First name", "First");
    Field f2 = newField(Type.STRING, "LAST_NAME", "Last name", "Last");
    Field f3 = newField(Type.STRING, "MIDDLE_NAME", "Middle name", "Middle");
    Field f4 = newField(Type.DATE, "BIRTH_DATE", "Birth Date", "Dob");
    Field f5 = newField(Type.DATE, "BAPTIZED_DATE", "Date Baptized", "Bap");

    List<Field> list = new ArrayList<>();
    list.add(f1);
    list.add(f2);
    list.add(f3);
    list.add(f4);
    list.add(f5);

    list.add(newField(Type.NUMBER, "PLACEMENTS", "Placements", "Place"));
    list.add(newField(Type.NUMBER, "VIDEO_SHOWINGS", "Video Showings", "Video"));
    list.add(newField(Type.NUMBER, "HOURS", "Hours", "Hrs"));
    list.add(newField(Type.NUMBER, "RETURN_VISITS", "Return Visits", "R.V."));
    list.add(newField(Type.NUMBER, "BIBLE_STUDIES", "Bible Studies", "BiSt"));
    list.add(newField(Type.STRING, "COMMENTS", "Comments", "Com"));
    list.add(newField(Type.LOOKUP, "GENDER", "Gender", "Sex"));

    mSql.upsert(list);

    Field field = mSql.select("FIRST_NAME", Type.STRING);

    Assert.assertEquals(true, field.getProperties() != null);
    Assert.assertEquals("First name", field.getProperties().getDisplay().getLong());
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

    fields.setGroup("JUNIT");
    fields.add(f1);
    fields.add(f2);
    fields.add(f3);

    mSql.upsert(fields);

    Fields ret = mSql.select("JUNIT");
    Assert.assertEquals(3, ret.getFields().size());
  }

  private Field newField(Type inType, String inName, String inLong, String inShort)
  {
    Field ret = new Field();
    ret.setName(inName);
    ret.setType(inType);
    ret.setProperties(new Properties());
    ret.getProperties().setDisplay(new Display());
    ret.getProperties().getDisplay().setLong(inLong);
    ret.getProperties().getDisplay().setShort(inShort);
    return ret;
  }
}