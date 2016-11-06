package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.util.ResourceUtil;

public class LookupSqlTest extends MySqlCoreDsTest
{
  private LookupSql mSql;

  @Before
  public void before()
  {
    mSql = new LookupSql(mDataSource);
  }

  @Test
  public void setupDaysOfWeek()
  {
    Group group = Group.DAYSOFWEEK;

    Lookup l1 = lookup(group, "Sunday", "Sun", 2, null);
    Lookup l2 = lookup(group, "Monday", "Mon", 4, null);
    Lookup l3 = lookup(group, "Tuesday", "Tue", 6, null);
    Lookup l4 = lookup(group, "Wednesday", "Wed", 8, null);
    Lookup l5 = lookup(group, "Thursday", "Thu", 10, null);
    Lookup l6 = lookup(group, "Friday", "Fri", 12, null);
    Lookup l7 = lookup(group, "Saturday", "Sat", 14, null);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);
    list.add(l2);
    list.add(l3);
    list.add(l4);
    list.add(l5);
    list.add(l6);
    list.add(l7);

    mSql.upsert(list);

    Assert.assertEquals(7, mSql.select(group.name()).size());
  }

  @Test
  public void setupMonthsOfYear()
  {
    Group group = Group.MONTHSOFYEAR;

    Lookup l1 = lookup(group, "January", "Jan", 1, null);
    Lookup l2 = lookup(group, "February", "Feb", 2, null);
    Lookup l3 = lookup(group, "March", "Mar", 3, null);
    Lookup l4 = lookup(group, "April", "Apr", 4, null);
    Lookup l5 = lookup(group, "May", "May", 5, null);
    Lookup l6 = lookup(group, "June", "Jun", 6, null);
    Lookup l7 = lookup(group, "July", "Jul", 7, null);
    Lookup l8 = lookup(group, "August", "Aug", 8, null);
    Lookup l9 = lookup(group, "September", "Sep", 9, null);
    Lookup l10 = lookup(group, "October", "Oct", 10, null);
    Lookup l11 = lookup(group, "November", "Nov", 11, null);
    Lookup l12 = lookup(group, "December", "Dec", 12, null);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);
    list.add(l2);
    list.add(l3);
    list.add(l4);
    list.add(l5);
    list.add(l6);
    list.add(l7);
    list.add(l8);
    list.add(l9);
    list.add(l10);
    list.add(l11);
    list.add(l12);

    mSql.upsert(list);

    Assert.assertEquals(12, mSql.select(group.name()).size());
  }

  @Test
  public void setupGender()
  {
    Group group = Group.GENDER;

    Lookup l1 = lookup(group, "Male", "M", 1, null);
    Lookup l2 = lookup(group, "Female", "F", 2, null);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);
    list.add(l2);

    mSql.upsert(list);

    Assert.assertEquals(2, mSql.select(group.name()).size());
  }

  @Test
  public void setupBlank()
  {
    Group group = Group.BLANK;

    Lookup l1 = lookup(group, "", "", 0, null);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);

    mSql.upsert(list);

    Assert.assertEquals(1, mSql.select(group.name()).size());
  }

  @Test
  public void setupUnknown()
  {
    Group group = Group.UNKNOWN;

    Lookup l1 = lookup(group, "Unknown", "U", 999, null);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);

    mSql.upsert(list);

    Assert.assertEquals(1, mSql.select(group.name()).size());
  }

  @Test
  public void setupYesNo()
  {
    Group group = Group.YESNO;

    Lookup l1 = lookup(group, "Yes", "Y", 1, null);
    Lookup l2 = lookup(group, "No", "N", 2, null);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);
    list.add(l2);

    mSql.upsert(list);

    Assert.assertEquals(2, mSql.select(group.name()).size());
  }

  @Test
  public void setupTables()
  {
    Group group = Group.TABLE;

    Lookup l1 = lookup(group, "JUNIT", "JT", 1, "Used for junit testing");
    Lookup l2 = lookup(group, "PERSON", "PER", 2, "Used to store person information.");

    List<Lookup> list = new ArrayList<>();
    list.add(l1);
    list.add(l2);

    mSql.upsert(list);

    Assert.assertEquals(2, mSql.select(group.name()).size());
  }

  @Test
  public void testUpsertAndSelect()
  {
    String text = "PROFILE_" + System.currentTimeMillis();

    Lookup model = new Lookup();
    model.setGroup(VALUE_TABLE);
    model.setName(VALUE_KEY);
    model.setXL(text);

    List<Lookup> list = new ArrayList<>();
    list.add(model);

    mSql.upsertXL(list);

    Lookup result = mSql.selectXL(VALUE_TABLE, VALUE_KEY);
    Assert.assertEquals(text, result.getXL());

    List<Lookup> results = mSql.selectXL(VALUE_TABLE);
    Assert.assertEquals(1, results.size());
  }

  @Test
  public void setupComponents1()
  {
    String xl = ResourceUtil.contents("Components1.xml");
    Lookup l1 = new Lookup();
    l1.setGroup(Group.COMPONENTS);
    l1.setName("Components1");
    l1.setXL(xl);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);

    mSql.upsertXL(list);

    Assert.assertEquals(l1.getGroup(), mSql.selectXL(l1.getGroup()).get(0).getGroup());
    Assert.assertEquals(xl, mSql.selectXL(l1.getGroup(), l1.getName()).getXL());
    System.out.println("Page1 Length:" + xl.length());
  }

  @Test
  public void setupComponents2()
  {
    String xl = ResourceUtil.contents("Components2.xml");
    Lookup l1 = new Lookup();
    l1.setGroup(Group.COMPONENTS);
    l1.setName("Components2");
    l1.setXL(xl);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);

    mSql.upsertXL(list);

    Assert.assertEquals(l1.getGroup(), mSql.selectXL(l1.getGroup()).get(0).getGroup());
    Assert.assertEquals(xl, mSql.selectXL(l1.getGroup(), l1.getName()).getXL());
    System.out.println("Page2 Length:" + xl.length());
  }

  @Test
  public void setupProfile0()
  {
    String xl = ResourceUtil.contents("Profile0.xml");
    Lookup l1 = new Lookup();
    l1.setId(3L);
    l1.setGroup(Group.APP_PROFILE);
    l1.setName("login");
    l1.setXL(xl);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);

    mSql.upsertXL(list);

    Assert.assertEquals(1, mSql.selectXL(l1.getGroup()).size());
    Assert.assertEquals(xl, mSql.selectXL(l1.getGroup(), l1.getName()).getXL());
  }

  @Test
  public void setupProfile3()
  {
    String xl = ResourceUtil.contents("Profile3.xml");
    Lookup l1 = new Lookup();
    l1.setId(3L);
    l1.setGroup(Group.PROFILE);
    l1.setName("simeonhearring");
    l1.setXL(xl);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);

    mSql.upsertXL(list);

    Assert.assertEquals(1, mSql.selectXL(l1.getGroup()).size());
    Assert.assertEquals(xl, mSql.selectXL(l1.getGroup(), l1.getName()).getXL());
  }

  private Lookup lookup(Group inGroup, String inName, String inAbbr, int inSort, String inDesc)
  {
    Lookup ret = new Lookup();
    ret.setGroup(inGroup);
    ret.setName(inName);
    ret.setAbbreviation(inAbbr);
    ret.setDescription(inDesc);
    ret.setSort(inSort);
    return ret;
  }
}