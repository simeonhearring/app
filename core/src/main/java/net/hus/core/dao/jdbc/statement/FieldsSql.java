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
  // FIELD
  private BatchSqlUpdate mFieldAppUpsert;
  private BatchSqlUpdate mFieldUpsert;
  private BatchSqlUpdate mFieldDelete;

  private MappingSqlQuery<Field> mField;
  private MappingSqlQuery<Field> mFieldById;
  private MappingSqlQuery<Field> mFieldByNameType;

  // FIELD_TABLE
  private BatchSqlUpdate mTableUpsert;
  private BatchSqlUpdate mTableDelete;
  private MappingSqlQuery<Field> mTableByTable;
  private MappingSqlQuery<String> mTables;

  public FieldsSql()
  {
    mStmts = getStatements("Fields.xml");
  }

  public FieldsSql(DataSource inDataSource)
  {
    this();

    mFieldAppUpsert = newBatchUpdate(inDataSource, "UPSERT_APP_FIELD");
    mFieldUpsert = newBatchUpdate(inDataSource, "UPSERT_FIELD");
    mTableUpsert = newBatchUpdate(inDataSource, "UPSERT_TABLE");
    mFieldDelete = newBatchUpdate(inDataSource, "DELETE_FIELD");
    mTableDelete = newBatchUpdate(inDataSource, "DELETE_TABLE");

    Statement fieldByNameType = mStmts.getStatement("SELECT_FIELD_BY_NAMETYPE");
    mFieldByNameType = new MappingSqlQuery<Field>(inDataSource, fieldByNameType.getSql())
    {
      @Override
      protected Field mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapField(new Field(), inRs);
      }
    };
    mFieldByNameType.setTypes(fieldByNameType.types());
    mFieldByNameType.compile();

    Statement fieldById = mStmts.getStatement("SELECT_FIELD_BY_ID");
    mFieldById = new MappingSqlQuery<Field>(inDataSource, fieldById.getSql())
    {
      @Override
      protected Field mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapField(new Field(), inRs);
      }
    };
    mFieldById.setTypes(fieldById.types());
    mFieldById.compile();

    Statement field = mStmts.getStatement("SELECT_FIELD");
    mField = new MappingSqlQuery<Field>(inDataSource, field.getSql())
    {
      @Override
      protected Field mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapField(new Field(), inRs);
      }
    };
    mField.compile();

    Statement tableByTable = mStmts.getStatement("SELECT_TABLE_BY_TABLE");
    mTableByTable = new MappingSqlQuery<Field>(inDataSource, tableByTable.getSql())
    {
      @Override
      protected Field mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapFields(new Field(), inRs);
      }
    };
    mTableByTable.setTypes(tableByTable.types());
    mTableByTable.compile();

    Statement table = mStmts.getStatement("SELECT_TABLE");
    mTables = new MappingSqlQuery<String>(inDataSource, table.getSql())
    {
      @Override
      protected String mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return inRs.getString("mTable");
      }
    };
    mTables.setTypes(table.types());
    mTables.compile();
  }

  public Field select(String inName, Field.Type inType)
  {
    List<Field> ret = mFieldByNameType.execute(params(inName, inType.name()));
    return only(ret);
  }

  public List<Field> select()
  {
    List<Field> ret = mField.execute();
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

  public void upsertapp(List<Field> inFields)
  {
    mFieldAppUpsert.reset();
    for (Field value : inFields)
    {
      Long id = value.getId();
      String name = value.getName();
      String type = value.getType().name();
      String properties = valueOf(value.getProperties(), new FieldPropertiesParser());

      mFieldAppUpsert.update(params(id, name, type, properties, id, properties));
    }
    mFieldAppUpsert.flush();
    mFieldAppUpsert.reset();
  }

  public void upsert(Fields inFields)
  {
    mTableUpsert.reset();
    String fgg = inFields.fgg();
    for (Field value : inFields.getFields())
    {
      Long id = value.getId();
      String display = null; // remove from db FGG table
      Integer sort = null; // remove from db FGG table

      mTableUpsert.update(params(fgg, id, display, sort, display, sort));
    }
    mTableUpsert.flush();
    mTableUpsert.reset();
  }

  public List<Field> selectByFgg(String inFgg)
  {
    return mTableByTable.execute(params(inFgg));
  }

  public List<String> selectTables()
  {
    return mTables.execute();
  }

  public Field select(Long inFieldId)
  {
    return only(mFieldById.execute(params(inFieldId)));
  }

  public void upsert(Field inField)
  {
    List<Field> list = new ArrayList<>();
    list.add(inField);
    upsert(list);
  }

  public void delete(Fields inTable)
  {
    mTableDelete.reset();
    for (Field value : inTable.getFields())
    {
      Long id = value.getId();
      mTableDelete.update(params(inTable.fgg(), id));
    }
    mTableDelete.flush();
    mTableDelete.reset();
  }

  public void delete(List<Field> inFields)
  {
    mFieldDelete.reset();
    for (Field value : inFields)
    {
      Long id = value.getId();
      mFieldDelete.update(params(id));
    }
    mFieldDelete.flush();
    mFieldDelete.reset();
  }
}