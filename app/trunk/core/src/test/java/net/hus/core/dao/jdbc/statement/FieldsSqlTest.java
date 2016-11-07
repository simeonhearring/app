package net.hus.core.dao.jdbc.statement;

import static net.hus.core.shared.model.Field.Fid.ADDRESS;
import static net.hus.core.shared.model.Field.Fid.FIRST_NAME;
import static net.hus.core.shared.model.Field.Fid.GENDER;
import static net.hus.core.shared.model.Field.Fid.LAST_NAME;
import static net.hus.core.shared.model.Field.Fid.MIDDLE_NAME;
import static net.hus.core.shared.model.Field.Fid.PASSWORD;
import static net.hus.core.shared.model.Field.Fid.PROFILE;
import static net.hus.core.shared.model.Field.Fid.USERNAME;

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
import net.hus.core.shared.model.Field.DateTime;
import net.hus.core.shared.model.Field.Display;
import net.hus.core.shared.model.Field.Fid;
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
    list.add(newField(USERNAME.type(), USERNAME.name(), "User Name", "UserNme"));
    list.add(newField(PASSWORD.type(), PASSWORD.name(), "Password", "Pswd"));
    list.add(newField(FIRST_NAME.type(), FIRST_NAME.name(), "First name", "First", true));
    list.add(newField(LAST_NAME.type(), LAST_NAME.name(), "Last name", "Last", true));
    list.add(newField(MIDDLE_NAME.type(), MIDDLE_NAME.name(), "Middle name", "Middle", true));
    list.add(newField(GENDER.type(), GENDER.name(), "Gender", "Sex", gender()));
    list.add(newField(ADDRESS.type(), ADDRESS.name(), "Address", "Addr.", address()));
    list.add(newField(PROFILE.type(), PROFILE.name(), "Profile", "User", profile()));

    list.add(newField(Type.DATE, "BIRTH_DATE", "Birth Date", "Dob", newDateTime()));
    list.add(newField(Type.STRING, "COMMENTS", "Comments", "Com"));

    mSql.upsert(list);

    Field field = mSql.select("FIRST_NAME", Type.STRING);

    Assert.assertEquals(true, field.getProperties() != null);
    Assert.assertEquals("First name", field.getProperties().getDisplay().getLong());
  }

  private DateTime newDateTime()
  {
    return new Field.DateTime("yyyy-MM-dd");
  }

  private Array address()
  {
    return newArray(6, "Type", "Street A", "Street B", "City", "State", "Zip");
  }

  private Lookup gender()
  {
    return new Lookup(Location.TABLE, "BLANK,GENDER,UNKNOWN");
  }

  private Lookup profile()
  {
    return new Lookup(Location.RPC, "BLANK,PROFILE");
  }

  private Array newArray(Integer inSize, String... inLabels)
  {
    Array ret = new Array(inSize, inLabels);
    ret.setProperties(new Array.Properties(10, true, "#CCC", "#FFF", HeadingSize.H5));
    return ret;
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
  public void testUpsertAndSelectFields()
  {
    Fields fields = new Fields();
    fields.setFields(new ArrayList<Field>());

    fields.fgg(FIELD_GROUP);
    fields.add(new Field(1L));
    fields.add(new Field(2L));
    fields.add(new Field(3L));
    fields.add(new Field(4L));
    fields.add(new Field(12L));
    fields.add(new Field(13L));
    fields.add(new Field(16L));

    mSql.upsert(fields);

    Fields ret = mSql.select(fields.fgg());
    Assert.assertEquals(fields.getFields().size(), ret.getFields().size());

    fields.fgg("LOGIN");
    fields.clear();
    fields.add(new Field(14L));
    fields.add(new Field(15L));
    mSql.upsert(fields);

    ret = mSql.select(fields.fgg());
    Assert.assertEquals(fields.getFields().size(), ret.getFields().size());
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

  private Field newField(Type inType, String inName, String inLong, String inShort,
      DateTime inDateTime)
  {
    Field ret = newField(inType, inName, inLong, inShort);
    ret.getProperties().setDateTime(inDateTime);
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