package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.hus.core.parser.FieldPropertiesParser;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookups;
import net.hus.core.shared.model.Model;
import net.hus.core.shared.model.Value;

public class Mapping extends AbstractSqlJdbc
{
  protected static void mapModel(Model inModel, ResultSet inRs) throws SQLException
  {
    inModel.setId(inRs.getLong("mId"));
    inModel.setCreated(inRs.getTimestamp("mCreated"));
    inModel.setUpdated(inRs.getTimestamp("mUpdated"));
  }

  protected static Lookups mapLookups(Lookups inOut, ResultSet inRs) throws SQLException
  {
    mapModel(inOut, inRs);

    inOut.setCode(inRs.getString("mCode"));
    inOut.setName(inRs.getString("mName"));

    return inOut;
  }

  protected static Lookup mapLookup(Lookup inOut, ResultSet inRs) throws SQLException
  {
    mapModel(inOut, inRs);

    inOut.setGroup(inRs.getString("mGroup"));
    inOut.setCode(inRs.getString("mCode"));
    inOut.setName(inRs.getString("mName"));
    inOut.setAbbreviation(inRs.getString("mAbbreviation"));
    inOut.setSort((Integer) inRs.getObject("mSort"));
    inOut.setAltId((Long) inRs.getObject("mAltId"));

    return inOut;
  }

  protected static Lookup mapLookupXL(Lookup inOut, ResultSet inRs) throws SQLException
  {
    mapModel(inOut, inRs);

    inOut.setGroup(inRs.getString("mGroup"));
    inOut.setCode(inRs.getString("mCode"));
    inOut.setName(inRs.getString("mName"));
    inOut.setXL(inRs.getString("mXL"));

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

    return inOut;
  }

  private static void mapField_(Field inOut, ResultSet inRs) throws SQLException
  {
    inOut.setCode(inRs.getString("mCode"));
    inOut.setType(valueOf(inRs.getString("mType"), Field.Type.values()));
    inOut.setProperties(valueOf(inRs.getString("mProperties"), new FieldPropertiesParser()));
  }

  protected static Value mapValue(Value inOut, ResultSet inRs) throws SQLException
  {
    mapModel(inOut, inRs);

    inOut.setFieldTKG(
        new FieldTKG(inRs.getString("mTable"), inRs.getString("mKey"), inRs.getString("mFTable")));
    inOut.setValue(inRs.getString("mValue"));
    inOut.setValueId((Long) inRs.getObject("mValueId"));
    inOut.setPos(inRs.getInt("mPos"));
    inOut.setAsOf(inRs.getTimestamp("mAsOf"));

    Field field = new Field();
    field.setId(inRs.getLong("mFId"));
    mapField_(field, inRs);

    inOut.setField(field);

    return inOut;
  }
}