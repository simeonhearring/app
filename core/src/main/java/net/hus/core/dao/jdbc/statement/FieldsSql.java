package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;

import net.hus.core.parser.FieldPropertiesParser;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Fields;

public class FieldsSql extends Mapping
{
  private BatchSqlUpdate mFieldUpsert;
  private MappingSqlQuery<Field> mFieldSelect;
  private MappingSqlQuery<Field> mFieldByIdSelect;
  private MappingSqlQuery<Field> mFieldAllSelect;
  private MappingSqlQuery<Object[]> mFieldsAllSelect;
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

    Statement selectById = mStmts.getStatement("SELECT_BY_ID");
    mFieldByIdSelect = new MappingSqlQuery<Field>(inDataSource, selectById.getSql())
    {
      @Override
      protected Field mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapField(new Field(), inRs);
      }
    };
    mFieldByIdSelect.setTypes(selectById.types());
    mFieldByIdSelect.compile();

    Statement selectAll = mStmts.getStatement("SELECT_ALL");
    mFieldAllSelect = new MappingSqlQuery<Field>(inDataSource, selectAll.getSql())
    {
      @Override
      protected Field mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapField(new Field(), inRs);
      }
    };
    mFieldAllSelect.compile();

    Statement selectfAll = mStmts.getStatement("SELECT_GROUP_ALL");
    mFieldsAllSelect = new MappingSqlQuery<Object[]>(inDataSource, selectfAll.getSql())
    {
      @Override
      protected Object[] mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapField(new Object[2], inRs);
      }
    };
    mFieldsAllSelect.compile();

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

  public List<Field> select()
  {
    List<Field> ret = mFieldAllSelect.execute();
    return ret;
  }

  public List<Object[]> selectGrp()
  {
    List<Object[]> ret = mFieldsAllSelect.execute();
    return ret;
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
    String fgg = inFields.fgg();
    for (Field value : inFields.getFields())
    {
      Long id = value.getId();
      String display = value.getDisplay();
      Integer sort = null;

      mFieldsUpsert.update(params(fgg, id, display, sort, display, sort));
    }
    mFieldsUpsert.flush();
    mFieldsUpsert.reset();
  }

  public Fields select(String inFgg)
  {
    Fields ret = new Fields();
    ret.fgg(inFgg);
    ret.setFields(mFieldsSelect.execute(params(inFgg)));
    return ret;
  }

  public Field select(Long inFieldId)
  {
    return only(mFieldByIdSelect.execute(params(inFieldId)));
  }
}