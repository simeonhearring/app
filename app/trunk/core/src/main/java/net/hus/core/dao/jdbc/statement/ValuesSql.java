package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;

import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;

public class ValuesSql extends Mapping
{
  private BatchSqlUpdate mBatchInsert;
  private BatchSqlUpdate mBatchUpdate;
  private MappingSqlQuery<Value> mSelectKey;
  private MappingSqlQuery<Value> mSelectKeyField;
  private MappingSqlQuery<Value> mSelectLastKey;

  public ValuesSql()
  {
    mStmts = getStatements("Values.xml");
  }

  public ValuesSql(DataSource inDataSource)
  {
    this();

    Statement insert = mStmts.getStatement("INSERT");
    mBatchInsert = new BatchSqlUpdate(inDataSource, insert.getSql(), insert.types());
    mBatchInsert.compile();

    Statement update = mStmts.getStatement("UPDATE");
    mBatchUpdate = new BatchSqlUpdate(inDataSource, update.getSql(), update.types());
    mBatchUpdate.compile();

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

    Statement lastKey = mStmts.getStatement("SELECT_LAST_KEY");
    mSelectLastKey = new MappingSqlQuery<Value>(inDataSource, lastKey.getSql())
    {
      @Override
      protected Value mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapValue(new Value(), inRs);
      }
    };
    mSelectLastKey.setTypes(lastKey.types());
    mSelectLastKey.compile();

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

  public void insertUpdate(List<Value> inList)
  {
    mBatchUpdate.reset();
    mBatchInsert.reset();
    for (Value value : inList)
    {
      String table = value.getTableFvk().getFvt();
      String key = value.getTableFvk().getFvk();
      String valueText = value.getValue();
      Long fieldId = value.getField().getId();
      Date asOf = value.getAsOf();
      if (value.getField().isOneValue())
      {
        mBatchUpdate.update(params(valueText, asOf, table, key, fieldId));
      }
      else
      {
        mBatchInsert.update(params(table, key, valueText, fieldId, asOf));
      }
    }
    mBatchInsert.flush();
    mBatchInsert.reset();
    mBatchUpdate.flush();
    mBatchUpdate.reset();
  }

  public void insert(List<Value> inList)
  {
    mBatchInsert.reset();
    for (Value value : inList)
    {
      String table = value.getTableFvk().getFvt();
      String key = value.getTableFvk().getFvk();
      String valueText = value.getValue();
      Long fieldId = value.getField().getId();
      Date asOf = value.getAsOf();
      mBatchInsert.update(params(table, key, valueText, fieldId, asOf));
    }
    mBatchInsert.flush();
    mBatchInsert.reset();
  }

  public void update(List<Value> inList)
  {
    mBatchUpdate.reset();
    for (Value value : inList)
    {
      String table = value.getTableFvk().getFvt();
      String key = value.getTableFvk().getFvk();
      String valueText = value.getValue();
      Long fieldId = value.getField().getId();
      Date asOf = value.getAsOf();
      mBatchUpdate.update(params(valueText, asOf, table, key, fieldId));
    }
    mBatchUpdate.flush();
    mBatchUpdate.reset();
  }

  protected List<Value> select(FieldTKG inTk)
  {
    List<Value> ret = mSelectKey.execute(params(inTk.getFvt(), inTk.getFvk()));
    return ret;
  }

  public List<Value> selectLast(FieldTKG inTk)
  {
    List<Value> ret = mSelectLastKey.execute(params(inTk.getFvt(), inTk.getFvk(), inTk.getFgg()));
    return ret;
  }

  protected List<Value> selectLast(List<FieldTKG> inTks)
  {
    List<Value> ret = new ArrayList<>();
    for (FieldTKG value : inTks)
    {
      ret.addAll(mSelectLastKey.execute(params(value.getFvt(), value.getFvk(), value.getFgg())));
    }
    return ret;
  }

  protected List<Value> select(FieldTKG inTk, Long inFieldId)
  {
    List<Value> ret = mSelectKeyField.execute(params(inTk.getFvt(), inTk.getFvk(), inFieldId));
    return ret;
  }
}