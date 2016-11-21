package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
  private MappingSqlQuery<Object[]> mFieldsByFggSelect;
  private BatchSqlUpdate mFieldsUpsert;
  private BatchSqlUpdate mFieldsDelete;
  private MappingSqlQuery<Field> mFieldByGrpSelect;

  public FieldsSql()
  {
    mStmts = getStatements("Fields.xml");
  }

  public FieldsSql(DataSource inDataSource)
  {
    this();

    mFieldUpsert = newBatchUpdate(inDataSource, "UPSERT");
    mFieldsUpsert = newBatchUpdate(inDataSource, "UPSERT_FIELDS");
    mFieldsDelete = newBatchUpdate(inDataSource, "DELETE_FIELDS");

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
        return mapField(new Object[3], inRs);
      }
    };
    mFieldsAllSelect.compile();

    Statement selectFgg = mStmts.getStatement("SELECT_GROUP_BY_FGG");
    mFieldsByFggSelect = new MappingSqlQuery<Object[]>(inDataSource, selectFgg.getSql())
    {
      @Override
      protected Object[] mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapField(new Object[3], inRs);
      }
    };
    mFieldsByFggSelect.setTypes(selectFgg.types());
    mFieldsByFggSelect.compile();

    Statement selectFields = mStmts.getStatement("SELECT_FIELDS_BY_GRP");
    mFieldByGrpSelect = new MappingSqlQuery<Field>(inDataSource, selectFields.getSql())
    {
      @Override
      protected Field mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapFields(new Field(), inRs);
      }
    };
    mFieldByGrpSelect.setTypes(selectFields.types());
    mFieldByGrpSelect.compile();
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

  public Object[] selectGrp(String inFgg)
  {
    List<Object[]> ret = mFieldsByFggSelect.execute(params(inFgg));
    return first(ret);
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
      String display = null; // remove from db FIELD_GROUP table
      Integer sort = null; // remove from db FIELD_GROUP table

      mFieldsUpsert.update(params(fgg, id, display, sort, display, sort));
    }
    mFieldsUpsert.flush();
    mFieldsUpsert.reset();
  }

  public Fields select(String inFgg)
  {
    Fields ret = new Fields();
    Object[] fgg = selectGrp(inFgg); // TODO go to lookup
    ret.fgg((String) fgg[0]);
    ret.setName((String) fgg[2]);
    ret.setFields(mFieldByGrpSelect.execute(params(inFgg)));
    return ret;
  }

  public Field select(Long inFieldId)
  {
    return only(mFieldByIdSelect.execute(params(inFieldId)));
  }

  public void upsert(Field inField)
  {
    List<Field> list = new ArrayList<>();
    list.add(inField);
    upsert(list);
  }

  public void delete(Fields inFields)
  {
    mFieldsDelete.reset();
    for (Field value : inFields.getFields())
    {
      Long id = value.getId();
      mFieldsDelete.update(params(inFields.fgg(), id));
    }
    mFieldsDelete.flush();
    mFieldsDelete.reset();
  }
}