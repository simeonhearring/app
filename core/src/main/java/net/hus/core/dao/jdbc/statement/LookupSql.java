package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;

import net.hus.core.model.Lookup;

public class LookupSql extends AbstractSqlJdbc
{
  private BatchSqlUpdate mBatchUpsert;
  private MappingSqlQuery<Lookup> mSelect;

  public LookupSql()
  {
    mStmts = getStatements("Lookup.xml");
  }

  public LookupSql(DataSource inDataSource)
  {
    this();

    mBatchUpsert = newBatchUpdate(inDataSource, "UPSERT");

    Statement select = mStmts.getStatement("SELECT");
    mSelect = new MappingSqlQuery<Lookup>(inDataSource, select.getSql())
    {
      @Override
      protected Lookup mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        Lookup ret = new Lookup();
        mapModel(ret, inRs);
        ret.setGroup(inRs.getString("mGroup"));
        ret.setName(inRs.getString("mName"));
        ret.setAbbreviation(inRs.getString("mAbbreviation"));
        ret.setSort((Integer) inRs.getObject("mSort"));
        return ret;
      }
    };
    mSelect.setTypes(select.types());
    mSelect.compile();
  }

  public List<Lookup> select(String inGroup)
  {
    List<Lookup> ret = mSelect.execute(params(inGroup));
    return ret;
  }

  public void upsert(List<Lookup> inLookup)
  {
    mBatchUpsert.reset();
    for (Lookup value : inLookup)
    {
      String group = value.getGroup();
      String name = value.getName();
      String abbr = value.getAbbreviation();
      Integer sort = value.getSort();
      mBatchUpsert.update(params(group, name, abbr, sort, abbr, sort));
    }
    mBatchUpsert.flush();
    mBatchUpsert.reset();
  }
}