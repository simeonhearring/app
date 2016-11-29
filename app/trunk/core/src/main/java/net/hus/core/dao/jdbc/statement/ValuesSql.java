package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;

import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;

public class ValuesSql extends Mapping
{
  private BatchSqlUpdate mInsert;
  private MappingSqlQuery<Value> mLastKey;
  private MappingSqlQuery<Value> mLastKeyPos;

  public ValuesSql()
  {
    mStmts = getStatements("Values.xml");
  }

  public ValuesSql(DataSource inDataSource)
  {
    this();

    Statement insert = mStmts.getStatement("INSERT");
    mInsert = new BatchSqlUpdate(inDataSource, insert.getSql(), insert.types());
    mInsert.compile();

    Statement lastKey = mStmts.getStatement("SELECT_LAST_KEY");
    mLastKey = new MappingSqlQuery<Value>(inDataSource, lastKey.getSql())
    {
      @Override
      protected Value mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapValue(new Value(), inRs);
      }
    };
    mLastKey.setTypes(lastKey.types());
    mLastKey.compile();

    Statement lastKeyPos = mStmts.getStatement("SELECT_LAST_KEY_POS");
    mLastKeyPos = new MappingSqlQuery<Value>(inDataSource, lastKeyPos.getSql())
    {
      @Override
      protected Value mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapValue(new Value(), inRs);
      }
    };
    mLastKeyPos.setTypes(lastKeyPos.types());
    mLastKeyPos.compile();
  }

  public void insert(List<Value> inList)
  {
    mInsert.reset();
    for (Value value : inList)
    {
      String fvt = value.getFieldTKG().getFvt();
      String fvk = value.getFieldTKG().getFvk();
      int pos = value.getPos();
      String valueText = value.getValue();
      Long valueId = value.getValueId();
      Long fieldId = value.getField().getId();
      Date asOf = value.getAsOf();
      mInsert.update(params(fvt, fvk, pos, valueText, valueId, fieldId, asOf));
    }
    mInsert.flush();
    mInsert.reset();
  }

  public List<Value> selectLast(FieldTKG inTk)
  {
    List<Value> ret = mLastKey.execute(params(inTk.getFvt(), inTk.getFvk(), inTk.getFgg()));
    return ret;
  }

  public List<Value> selectLastPos(FieldTKG inTk)
  {
    List<Value> ret = mLastKeyPos.execute(params(inTk.getFvt(), inTk.getFvk(), inTk.getFgg()));
    return ret;
  }
}