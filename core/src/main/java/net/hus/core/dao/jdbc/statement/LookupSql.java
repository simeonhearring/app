package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;

import net.hus.core.model.Lookup;
import net.hus.core.model.Lookup.Group;

public class LookupSql extends Mapping
{
  private BatchSqlUpdate mBatchUpsert;
  private MappingSqlQuery<Lookup> mSelect;

  private BatchSqlUpdate mBatchUpsertXL;
  private MappingSqlQuery<Lookup> mSelectXLgn;
  private MappingSqlQuery<Lookup> mSelectXLg;

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
        return mapLookup(new Lookup(), inRs);
      }
    };
    mSelect.setTypes(select.types());
    mSelect.compile();

    mBatchUpsertXL = newBatchUpdate(inDataSource, "UPSERT_XL");

    Statement selectXLgn = mStmts.getStatement("SELECT_XL_GN");
    mSelectXLgn = new MappingSqlQuery<Lookup>(inDataSource, selectXLgn.getSql())
    {
      @Override
      protected Lookup mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapLookupXL(new Lookup(), inRs);
      }
    };
    mSelectXLgn.setTypes(selectXLgn.types());
    mSelectXLgn.compile();

    Statement selectXLg = mStmts.getStatement("SELECT_XL_G");
    mSelectXLg = new MappingSqlQuery<Lookup>(inDataSource, selectXLg.getSql())
    {
      @Override
      protected Lookup mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapLookupXL(new Lookup(), inRs);
      }
    };
    mSelectXLg.setTypes(selectXLg.types());
    mSelectXLg.compile();
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
      String desc = value.getDescription();
      Integer sort = value.getSort();
      mBatchUpsert.update(params(group, name, abbr, desc, sort, abbr, desc, sort));
    }
    mBatchUpsert.flush();
    mBatchUpsert.reset();
  }

  public void upsertXL(List<Lookup> inLookup)
  {
    mBatchUpsertXL.reset();
    for (Lookup value : inLookup)
    {
      String group = value.getGroup();
      String name = value.getName();
      String xl = value.getXL();
      mBatchUpsertXL.update(params(group, name, xl, xl));
    }
    mBatchUpsertXL.flush();
    mBatchUpsertXL.reset();
  }

  public List<Lookup> selectXL(String inGroup)
  {
    List<Lookup> ret = mSelectXLg.execute(params(inGroup));
    return ret;
  }

  public Lookup selectXL(Group inGroup, String inName)
  {
    return selectXL(inGroup.name(), inName);
  }

  protected Lookup selectXL(String inGroup, String inName)
  {
    List<Lookup> ret = mSelectXLgn.execute(params(inGroup, inName));
    return only(ret);
  }
}