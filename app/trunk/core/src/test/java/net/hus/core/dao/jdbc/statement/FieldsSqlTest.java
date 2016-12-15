package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.Array;
import net.hus.core.shared.model.Field.Database;
import net.hus.core.shared.model.Field.Fid;
import net.hus.core.shared.model.Field.Lookup;
import net.hus.core.shared.model.Field.Type;

public class FieldsSqlTest extends MySqlCoreDsTest
{
  private FieldsSql mSql;

  @Before
  public void before()
  {
    mSql = new FieldsSql(mDataSource);
  }

  @Test
  @Ignore
  public void testUpsertAndSelectField()
  {
    List<Field> list = new ArrayList<>();
    // list.add(newField(ADDRESS.type(), ADDRESS.name(), "Address", "Addr.",
    // address()));
    // list.add(newField(Type.DATE, "BIRTH_DATE", "Birth Date", "Dob",
    // "yyyy-MM-dd"));
    // list.add(newField(Type.STRING, "COMMENTS", "Comments", "Com"));

    mSql.upsert(list);

    Field field = mSql.select("FIRST_NAME", Type.STRING);

    Assert.assertEquals(true, field.getProperties() != null);
    Assert.assertEquals("First name", field.getProperties().getDisplay().getLong());
  }

  @Test
  public void testCorrectId()
  {
    for (Fid value : Fid.values())
    {
      Assert.assertEquals(value.name() + " incorrect", value.fid(),
          mSql.select(value.name(), value.type()).getId());
    }
  }

  @Test
  public void testSelectAll()
  {
    Assert.assertEquals(true, mSql.select().size() > 0);
    Assert.assertEquals(true, mSql.select().size() > 0);
  }

  private Array address()
  {
    return newArray(6, "Type", "Street A", "Street B", "City", "State", "Zip");
  }

  private Array newArray(Integer inSize, String... inLabels)
  {
    Array ret = new Array(inSize, inLabels);
    ret.setProperties(new Array.Properties(500, 10, true, "#CCC", "#FFF", HeadingSize.H5));
    return ret;
  }

  private Field newField(Type inType, String inName, String inLong, String inShort)
  {
    Field ret = new Field();
    ret.setName(inName);
    ret.setType(inType);
    ret.getProperties().setType(inType);
    ret.getProperties().getDisplay().setLong(inLong);
    ret.getProperties().getDisplay().setShort(inShort);
    return ret;
  }

  private Field newField(Type inType, String inName, String inLong, String inShort, Array inArray)
  {
    Field ret = newField(inType, inName, inLong, inShort);
    ret.setArray(inArray);
    return ret;
  }

  private Field newField(Type inType, String inName, String inLong, String inShort, String inFormat)
  {
    Field ret = newField(inType, inName, inLong, inShort);
    ret.getProperties().getDateTime().setFormat(inFormat);
    return ret;
  }

  private Field newField(Type inType, String inName, String inLong, String inShort, Lookup inLookup)
  {
    Field ret = newField(inType, inName, inLong, inShort);
    ret.setLookup(inLookup);
    return ret;
  }

  private Field newField(Type inType, String inName, String inLong, String inShort,
      boolean inOneValue)
  {
    Field ret = newField(inType, inName, inLong, inShort);
    Database db = new Database();
    db.setOneValue(inOneValue);
    ret.getProperties().getDatabase().setOneValue(inOneValue);
    return ret;
  }
}