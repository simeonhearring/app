package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;

public class ProfileSql extends AbstractSqlJdbc
{
  private Statements mStmts;

  private BatchSqlUpdate mBatchUpsert;
  private MappingSqlQuery<String> mSelect;

  public ProfileSql()
  {
    mStmts = getStatements("Profile.xml");
  }

  public ProfileSql(DataSource inDataSource)
  {
    this();
    Statement upsert = mStmts.getStatement("UPSERT");
    mBatchUpsert = new BatchSqlUpdate(inDataSource, upsert.getSql(), upsert.types());
    mBatchUpsert.compile();

    Statement select = mStmts.getStatement("SELECT");
    mSelect = new MappingSqlQuery<String>(inDataSource, select.getSql())
    {
      @Override
      protected String mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return inRs.getString("mText");
      }
    };
    mSelect.setTypes(select.types());
    mSelect.compile();
  }

  public String select(String inCompany, String inName)
  {
    List<String> list = mSelect.execute(params(inCompany, inName));
    return only(list);
  }

  public void upsert(List<String[]> inProfiles)
  {
    mBatchUpsert.reset();
    for (String[] value : inProfiles)
    {
      String org = value[0];
      String name = value[1];
      String text = value[2];
      mBatchUpsert.update(params(org, name, text, text));
    }
    mBatchUpsert.flush();
    mBatchUpsert.reset();
  }
}