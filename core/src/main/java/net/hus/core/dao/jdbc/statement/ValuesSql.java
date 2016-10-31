package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;

import net.hus.core.model.TableFvk;
import net.hus.core.model.Value;

public class ValuesSql extends Mapping
{
  private BatchSqlUpdate mBatchInsert;
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

  public void insert(List<Value> inList)
  {
    mBatchInsert.reset();
    for (Value value : inList)
    {
      String table = value.getTableKey().getTable();
      String key = value.getTableKey().getFvk();
      String valueText = value.getValue();
      Long fieldId = value.getField().getId();
      Date asOf = value.getAsOf();
      mBatchInsert.update(params(table, key, valueText, fieldId, asOf));
    }
    mBatchInsert.flush();
    mBatchInsert.reset();
  }

  protected List<Value> select(TableFvk inTk)
  {
    List<Value> ret = mSelectKey.execute(params(inTk.getTable(), inTk.getFvk()));
    return ret;
  }

  public List<Value> selectLast(TableFvk inTk)
  {
    List<Value> ret =
        mSelectLastKey.execute(params(inTk.getTable(), inTk.getFvk(), inTk.getGroup()));
    return ret;
  }

  protected List<Value> selectLast(List<TableFvk> inTks)
  {
    List<Value> ret = new ArrayList<>();
    for (TableFvk value : inTks)
    {
      ret.addAll(
          mSelectLastKey.execute(params(value.getTable(), value.getFvk(), value.getGroup())));
    }
    return ret;
  }

  protected List<Value> select(TableFvk inTk, Long inFieldId)
  {
    List<Value> ret = mSelectKeyField.execute(params(inTk.getTable(), inTk.getFvk(), inFieldId));
    return ret;
  }
}