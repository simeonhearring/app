package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.hus.core.model.Field;
import net.hus.core.model.Lookup;
import net.hus.core.model.Model;
import net.hus.core.model.TableKey;
import net.hus.core.model.Value;
import net.hus.core.parser.FieldPropertiesParser;

public class Mapping extends AbstractSqlJdbc
{
  protected static void mapModel(Model inModel, ResultSet inRs) throws SQLException
  {
    inModel.setId(inRs.getLong("mId"));
    inModel.setCreated(inRs.getTimestamp("mCreated"));
    inModel.setUpdated(inRs.getTimestamp("mUpdated"));
  }

  protected static Lookup mapLookup(Lookup inOut, ResultSet inRs) throws SQLException
  {
    mapModel(inOut, inRs);

    inOut.setGroup(inRs.getString("mGroup"));
    inOut.setName(inRs.getString("mName"));
    inOut.setAbbreviation(inRs.getString("mAbbreviation"));
    inOut.setSort((Integer) inRs.getObject("mSort"));

    return inOut;
  }

  protected static Field mapField(Field inOut, ResultSet inRs) throws SQLException
  {
    mapModel(inOut, inRs);
    mapField_(inOut, inRs);

    return inOut;
  }

  protected static Field mapFields(Field inOut, ResultSet inRs) throws SQLException
  {
    mapField(inOut, inRs);
    mapFields_(inOut, inRs);

    return inOut;
  }

  private static void mapField_(Field inOut, ResultSet inRs) throws SQLException
  {
    inOut.setName(inRs.getString("mName"));
    inOut.setType(valueOf(inRs.getString("mType"), Field.Type.values()));
    inOut.setProperties(valueOf(inRs.getString("mProperties"), new FieldPropertiesParser()));
  }

  private static void mapFields_(Field inOut, ResultSet inRs) throws SQLException
  {
    inOut.setDisplay(inRs.getString("mDisplay"));
    inOut.setSort((Integer) inRs.getObject("mSort"));
  }

  protected static Value mapValue(Value inOut, ResultSet inRs) throws SQLException
  {
    mapModel(inOut, inRs);

    inOut.setTableKey(
        new TableKey(inRs.getString("mTable"), inRs.getString("mKey"), inRs.getString("mGroup")));
    inOut.setValue(inRs.getString("mValue"));
    inOut.setAsOf(inRs.getTimestamp("mAsOf"));

    Field field = new Field();
    field.setId(inRs.getLong("mFieldId"));
    mapField_(field, inRs);
    mapFields_(field, inRs);

    inOut.setField(field);

    return inOut;
  }

  protected static String mapProfileText(ResultSet inRs) throws SQLException
  {
    return inRs.getString("mText");
  }
}