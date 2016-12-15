package net.hus.core.dao.jdbc.statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.MappingSqlQuery;

import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.model.Lookups;

public class LookupSql extends Mapping
{
  private BatchSqlUpdate mBatchUpsert;
  private MappingSqlQuery<Lookup> mSelectg;
  private MappingSqlQuery<Lookups> mSelectgn;

  private MappingSqlQuery<String> mSelectGrps;

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
    mSelectg = new MappingSqlQuery<Lookup>(inDataSource, select.getSql())
    {
      @Override
      protected Lookup mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapLookup(new Lookup(), inRs);
      }
    };
    mSelectg.setTypes(select.types());
    mSelectg.compile();

    Statement selectgn = mStmts.getStatement("SELECT_GN");
    mSelectgn = new MappingSqlQuery<Lookups>(inDataSource, selectgn.getSql())
    {
      @Override
      protected Lookups mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return mapLookups(new Lookups(), inRs);
      }
    };
    mSelectgn.setTypes(selectgn.types());
    mSelectgn.compile();

    Statement selectGrps = mStmts.getStatement("SELECT_GRPS");
    mSelectGrps = new MappingSqlQuery<String>(inDataSource, selectGrps.getSql())
    {
      @Override
      protected String mapRow(ResultSet inRs, int inRowNum) throws SQLException
      {
        return inRs.getString("mGroup");
      }
    };
    mSelectGrps.compile();

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
    List<Lookup> ret = mSelectg.execute(params(inGroup));
    return ret;
  }

  public Lookups select(String inGroup, String inName)
  {
    Lookups ret = only(mSelectgn.execute(params(inGroup, inName)));
    ret.setLookups(select(inName));
    return ret;
  }

  public void upsert(List<Lookup> inLookup)
  {
    mBatchUpsert.reset();
    for (Lookup value : inLookup)
    {
      String group = value.getGroup();
      String name = value.getCode();
      String display = value.getDisplay();
      String abbr = value.getAbbreviation();
      String desc = value.getDescription();
      Integer sort = value.getSort();
      Long altId = value.getAltId();
      mBatchUpsert.update(
          params(group, name, display, abbr, desc, sort, altId, display, abbr, desc, sort, altId));
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
      String name = value.getCode();
      String display = value.getDisplay();
      String xl = value.getXL();
      mBatchUpsertXL.update(params(group, name, display, xl, display, xl));
    }
    mBatchUpsertXL.flush();
    mBatchUpsertXL.reset();
  }

  public List<Lookup> selectXL(String inGroup)
  {
    List<Lookup> ret = mSelectXLg.execute(params(inGroup));
    return ret;
  }

  public List<String> selectGrps()
  {
    List<String> ret = mSelectGrps.execute();
    return ret;
  }

  public Lookup selectXL(Group inGroup, String inName)
  {
    return selectXL(inGroup.name(), inName);
  }

  public Lookup selectXL(String inGroup, String inName)
  {
    List<Lookup> ret = mSelectXLgn.execute(params(inGroup, inName));
    return only(ret);
  }
}