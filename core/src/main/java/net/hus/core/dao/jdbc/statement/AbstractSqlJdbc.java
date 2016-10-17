package net.hus.core.dao.jdbc.statement;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.object.BatchSqlUpdate;

import com.thoughtworks.xstream.XStream;

import net.hus.core.model.Model;
import net.hus.core.parser.Parser;
import net.hus.core.util.EnumUtil;
import net.hus.core.util.ResourceUtil;

public abstract class AbstractSqlJdbc
{
  private static final Map<String, Integer> MAP = getJdbcTypeName();

  protected Statements mStmts;

  public void mapModel(Model inModel, ResultSet inResultSet) throws SQLException
  {
    inModel.setId(inResultSet.getLong("mId"));
    inModel.setCreated(inResultSet.getTimestamp("mCreated"));
    inModel.setUpdated(inResultSet.getTimestamp("mUpdated"));
  }

  public String getSql(Class<?> inClass)
  {
    return ResourceUtil.getSql(inClass);
  }

  public String sqlFile()
  {
    return getSql(this.getClass());
  }

  public String fileContent(String inFileName)
  {
    String s = this.getClass().getName().replaceAll("\\.", "/");
    s = s.replaceAll(this.getClass().getSimpleName(), inFileName);
    return ResourceUtil.contents(s);
  }

  public static <T> T first(List<T> inList)
  {
    return (inList != null) && (inList.size() > 0) ? inList.get(0) : null;
  }

  public static <T> T only(List<T> inList)
  {
    return (inList != null) && (inList.size() == 1) ? inList.get(0) : null;
  }

  public static <T extends Enum<?>> T valueOf(String inValue, T[] inValues)
  {
    return EnumUtil.valueOf(inValue, inValues);
  }

  public static <T> T valueOf(String inValue, Parser<T> inParser)
  {
    return inParser.fromXml(inValue);
  }

  public static <T> String valueOf(T inObj, Parser<T> inParser)
  {
    return inParser.toXml(inObj);
  }

  protected static int[] types(int... inTypes)
  {
    return inTypes;
  }

  public static String replaceIn(String inSql, int inLength)
  {
    return inSql.replaceAll("=\\?", replaceIn(inLength));
  }

  public static String replaceIn(int inLength)
  {
    StringBuilder sb = new StringBuilder(" in (");
    for (int i = 0; i < inLength; i++)
    {
      if (i != 0)
      {
        sb.append(",");
      }
      sb.append("?");
    }
    sb.append(")");
    return sb.toString();
  }

  protected static Object[] params(Object... inTypes)
  {
    return inTypes;
  }

  public static int[] numericTypes(int inLength)
  {
    int[] ret = new int[inLength];
    for (int i = 0; i < inLength; i++)
    {
      ret[i] = Types.NUMERIC;
    }
    return ret;
  }

  public Statements getStatements(String inXmlName)
  {
    String fileContent = fileContent(inXmlName);
    return fromXml(fileContent);
  }

  protected static Statements fromXml(String inXml)
  {
    XStream xs = xStream();

    Statements ret = (Statements) xs.fromXML(inXml);

    return ret;
  }

  private static XStream xStream()
  {
    XStream ret = new XStream();

    ret.alias("Statements", Statements.class);
    ret.addImplicitMap(Statements.class, "mStmt", null, Statement.class, "mKey");

    ret.alias("Statement", Statement.class);
    ret.aliasField("Key", Statement.class, "mKey");
    ret.aliasField("Types", Statement.class, "mTypes");
    ret.aliasField("Types", Statement.class, "mTypes");
    ret.aliasField("Sql", Statement.class, "mSql");

    return ret;
  }

  private static Map<String, Integer> getJdbcTypeName()
  {
    Map<String, Integer> ret = new HashMap<>();
    try
    {
      Field[] fields = java.sql.Types.class.getFields();
      for (Field field : fields)
      {
        String name = field.getName();
        Integer value = (Integer) field.get(null);
        ret.put(name, value);
      }
    }
    catch (IllegalAccessException e)
    {
      // do nothing
    }
    return ret;
  }

  public static class Statements
  {
    private Map<String, Statement> mStmt;

    public Statement getStatement(String inKey)
    {
      return mStmt.get(inKey);
    }
  }

  public static class Statement
  {
    public String mKey;

    private String mTypes;
    private String mSql;

    public String getSql()
    {
      return mSql;
    }

    public int[] types()
    {
      int[] ret = null;
      if (mTypes != null && mTypes.length() > 0)
      {
        String[] types = mTypes.split(",");
        ret = new int[types.length];
        for (int i = 0; i < types.length; i++)
        {
          ret[i] = MAP.get(types[i]);
        }
      }
      return ret;
    }
  }

  protected BatchSqlUpdate newBatchUpdate(DataSource inDataSource, String inKey)
  {
    Statement stmt = mStmts.getStatement(inKey);
    BatchSqlUpdate ret = new BatchSqlUpdate(inDataSource, stmt.getSql(), stmt.types());
    ret.compile();
    return ret;
  }
}