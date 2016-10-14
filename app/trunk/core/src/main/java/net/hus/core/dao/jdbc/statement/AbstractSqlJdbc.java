package net.hus.core.dao.jdbc.statement;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

import net.hus.core.util.EnumUtil;
import net.hus.core.util.ResourceUtil;
import net.hus.core.xstream.XStreamOmitMissingFields;

public abstract class AbstractSqlJdbc
{
  private static final Map<String, Integer> MAP = getJdbcTypeName();

  public String getSql(Class<?> inClass)
  {
    return ResourceUtil.getSql(inClass);
  }

  public String sqlFile()
  {
    return getSql(this.getClass());
  }

  public String getSql(String inName)
  {
    String s = this.getClass().getName().replaceAll("\\.", "/");
    s = s.replaceAll(this.getClass().getSimpleName(), inName);
    return ResourceUtil.contents(s);
  }

  public Sql getSqlObj(String inXmlName)
  {
    String sql = getSql(inXmlName);
    return fromXml(sql);
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

  protected static Sql fromXml(String inXml)
  {
    XStream xStream = new XStreamOmitMissingFields();
    xStream.alias("Sql", Sql.class);

    Sql ret = (Sql) xStream.fromXML(inXml);

    convertTypes(ret);

    return ret;
  }

  private static void convertTypes(Sql inSql)
  {
    if (inSql.mTypesText != null)
    {
      String[] types = inSql.mTypesText.split(",");
      int[] ret = new int[types.length];
      for (int i = 0; i < types.length; i++)
      {
        ret[i] = MAP.get(types[i]);
      }
      inSql.mTypes = ret;
    }
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

  public static class Sql
  {
    private int[] mTypes;
    private String mSql;

    private String mTypesText;

    public String getSql()
    {
      return mSql;
    }

    public int[] getTypes()
    {
      return mTypes;
    }
  }
}