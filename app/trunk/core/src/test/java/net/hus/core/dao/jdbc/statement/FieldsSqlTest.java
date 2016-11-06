package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.Array;
import net.hus.core.shared.model.Field.Database;
import net.hus.core.shared.model.Field.Display;
import net.hus.core.shared.model.Field.Lookup;
import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.shared.model.Field.Properties;
import net.hus.core.shared.model.Field.Type;
import net.hus.core.shared.model.Fields;

public class FieldsSqlTest extends MySqlCoreDsTest
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
    List<Field> list = new ArrayList<>();
    list.add(newField(Type.STRING, "USERNAME", "User Name", "UserNme", true));
    list.add(newField(Type.STRING, "PASSWORD", "Password", "Pswd", true));

    list.add(newField(Type.STRING, "FIRST_NAME", "First name", "First"));
    list.add(newField(Type.STRING, "LAST_NAME", "Last name", "Last"));
    list.add(newField(Type.STRING, "MIDDLE_NAME", "Middle name", "Middle"));
    list.add(newField(Type.DATE, "BIRTH_DATE", "Birth Date", "Dob"));
    // list.add(newField(Type.DATE, "BAPTIZED_DATE", "Date Baptized", "Bap"));

    list.add(newField(Type.STRING, "COMMENTS", "Comments", "Com"));
    list.add(newField(Type.LOOKUP, "GENDER", "Gender", "Sex",
        new Lookup(Location.TABLE, "BLANK,GENDER,UNKNOWN")));
    list.add(newField(Type.ARRAY, "ADDRESS", "Address", "Addr.",
        newArray(6, "Type", "Street A", "Street B", "City", "State", "Zip")));

    mSql.upsert(list);

    Field field = mSql.select("FIRST_NAME", Type.STRING);

    Assert.assertEquals(true, field.getProperties() != null);
    Assert.assertEquals("First name", field.getProperties().getDisplay().getLong());
  }

  private Array newArray(Integer inSize, String... inLabels)
  {
    Array ret = new Array(inSize, inLabels);
    ret.setProperties(new Array.Properties(10, true, "#CCC", "#FFF", HeadingSize.H5));
    return ret;
  }

  @Test
  public void testUpsertAndSelectFields()
  {
    Fields fields = new Fields();
    fields.setFields(new ArrayList<Field>());

    fields.fgg(FIELD_GROUP);
    fields.add(new Field(1L));
    fields.add(new Field(2L));
    fields.add(new Field(3L));
    fields.add(new Field(12L));
    fields.add(new Field(13L));

    mSql.upsert(fields);

    Fields ret = mSql.select(FIELD_GROUP);
    Assert.assertEquals(5, ret.getFields().size());

    fields.fgg("LOGIN");
    fields.clear();
    fields.add(new Field(14L));
    fields.add(new Field(15L));
    mSql.upsert(fields);
  }

  private Field newField(Type inType, String inName, String inLong, String inShort)
  {
    Field ret = new Field();
    ret.setName(inName);
    ret.setType(inType);
    ret.setProperties(new Properties());
    ret.getProperties().setType(inType);
    ret.getProperties().setDisplay(new Display());
    ret.getProperties().getDisplay().setLong(inLong);
    ret.getProperties().getDisplay().setShort(inShort);
    return ret;
  }

  private Field newField(Type inType, String inName, String inLong, String inShort, Array inArray)
  {
    Field ret = newField(inType, inName, inLong, inShort);
    ret.getProperties().setArray(inArray);
    return ret;
  }

  private Field newField(Type inType, String inName, String inLong, String inShort, Lookup inLookup)
  {
    Field ret = newField(inType, inName, inLong, inShort);
    ret.getProperties().setLookupGroup(inLookup);
    return ret;
  }

  private Field newField(Type inType, String inName, String inLong, String inShort,
      boolean inOneValue)
  {
    Field ret = newField(inType, inName, inLong, inShort);
    Database db = new Database();
    db.setOneValue(inOneValue);
    ret.getProperties().setDatabase(db);
    return ret;
  }
}