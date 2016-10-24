package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;

import net.hus.core.model.Field;
import net.hus.core.model.Value;

public class ValuesSql extends AbstractSqlJdbc
{
  private BatchSqlUpdate mBatchInsert;
  private MappingSqlQuery<Value> mSelectKey;
  private MappingSqlQuery<Value> mSelectKeyField;

  public ValuesSql()
  {
    mStmts = getStatements("Values.xml");
  }

  public ValuesSql(DataSource inDataSource)
  {
    this();

    Statement upsert = mStmts.getStatement("INSERT");
    mBatchInsert = new BatchSqlUpdate(inDataSource, upsert.getSql(), upsert.types());
    mBatchInsert.compile();

    Statement key = mStmts.getStatement("SELECT_KEY");
    mSelectKey = new MappingSqlQuery<Value>(inDataSource, key.getSql())
    {
      @Override
      protected Value mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapValue(new Value(), inRs);
      }
    };
    mSelectKey.setTypes(key.types());
    mSelectKey.compile();

    Statement keyField = mStmts.getStatement("SELECT_KEY_FIELD");
    mSelectKeyField = new MappingSqlQuery<Value>(inDataSource, keyField.getSql())
    {
      @Override
      protected Value mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapValue(new Value(), inRs);
      }
    };
    mSelectKeyField.setTypes(keyField.types());
    mSelectKeyField.compile();
  }

  public void insert(List<Value> inList)
  {
    mBatchInsert.reset();
    for (Value value : inList)
    {
      String key = value.getKey();
      String valueValue = value.getValue();
      Long fieldId = value.getField().getId();
      Date asOf = value.getAsOf();
      mBatchInsert.update(params(key, valueValue, fieldId, asOf));
    }
    mBatchInsert.flush();
    mBatchInsert.reset();
  }

  public List<Value> select(String inKey)
  {
    List<Value> ret = mSelectKey.execute(params(inKey));
    return ret;
  }

  public List<Value> select(String inKey, Long inFieldId)
  {
    List<Value> ret = mSelectKeyField.execute(params(inKey, inFieldId));
    return ret;
  }

  private Value mapValue(Value inOut, ResultSet inRs) throws SQLException
  {
    mapModel(inOut, inRs);

    inOut.setKey(inRs.getString("mKey"));
    inOut.setValue(inRs.getString("mValue"));
    inOut.setAsOf(inRs.getTimestamp("mAsOf"));

    Field field = new Field();
    field.setId(inRs.getLong("mFieldId"));
    FieldsSql.mapField_(field, inRs);
    FieldsSql.mapFields_(field, inRs);

    inOut.setField(field);

    return inOut;
  }
}