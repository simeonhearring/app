package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;

import net.hus.core.model.Field;
import net.hus.core.model.Fields;
import net.hus.core.parser.FieldPropertiesParser;

public class FieldsSql extends AbstractSqlJdbc
{
  private BatchSqlUpdate mFieldUpsert;
  private MappingSqlQuery<Field> mFieldSelect;
  private BatchSqlUpdate mFieldsUpsert;
  private MappingSqlQuery<Field> mFieldsSelect;

  public FieldsSql()
  {
    mStmts = getStatements("Fields.xml");
  }

  public FieldsSql(DataSource inDataSource)
  {
    this();

    mFieldUpsert = newBatchUpdate(inDataSource, "UPSERT");
    mFieldsUpsert = newBatchUpdate(inDataSource, "UPSERT_FIELDS");

    Statement select = mStmts.getStatement("SELECT");
    mFieldSelect = new MappingSqlQuery<Field>(inDataSource, select.getSql())
    {
      @Override
      protected Field mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapField(new Field(), inRs);
      }
    };
    mFieldSelect.setTypes(select.types());
    mFieldSelect.compile();

    Statement selectFields = mStmts.getStatement("SELECT_FIELDS");
    mFieldsSelect = new MappingSqlQuery<Field>(inDataSource, selectFields.getSql())
    {
      @Override
      protected Field mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapFields(new Field(), inRs);
      }
    };
    mFieldsSelect.setTypes(selectFields.types());
    mFieldsSelect.compile();
  }

  public Field select(String inName, Field.Type inType)
  {
    List<Field> ret = mFieldSelect.execute(params(inName, inType.name()));
    return only(ret);
  }

  public void upsert(List<Field> inFields)
  {
    mFieldUpsert.reset();
    for (Field value : inFields)
    {
      String name = value.getName();
      String type = value.getType().name();
      String properties = valueOf(value.getProperties(), new FieldPropertiesParser());

      mFieldUpsert.update(params(name, type, properties, properties));
    }
    mFieldUpsert.flush();
    mFieldUpsert.reset();
  }

  public void upsert(Fields inFields)
  {
    mFieldsUpsert.reset();
    String group = inFields.getGroup();
    for (Field value : inFields.getFields())
    {
      Long id = value.getId();
      String display = value.getDisplay();
      Integer sort = value.getSort();

      mFieldsUpsert.update(params(group, id, display, sort, display, sort));
    }
    mFieldsUpsert.flush();
    mFieldsUpsert.reset();
  }

  public Fields select(String inGroup)
  {
    Fields ret = new Fields();
    ret.setGroup(inGroup);
    ret.setFields(mFieldsSelect.execute(params(inGroup)));
    return ret;
  }

  private Field mapField(Field inOutField, ResultSet inRs) throws SQLException
  {
    mapModel(inOutField, inRs);

    inOutField.setName(inRs.getString("mName"));
    inOutField.setType(valueOf(inRs.getString("mType"), Field.Type.values()));
    inOutField.setProperties(valueOf(inRs.getString("mProperties"), new FieldPropertiesParser()));

    return inOutField;
  }

  private Field mapFields(Field inOutField, ResultSet inRs) throws SQLException
  {
    mapField(inOutField, inRs);

    inOutField.setDisplay(inRs.getString("mDisplay"));
    inOutField.setSort((Integer) inRs.getObject("mSort"));

    return inOutField;
  }
}