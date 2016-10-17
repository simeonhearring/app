package net.hus.core.dao.jdbc.statement;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.dao.jdbc.MySqlCoreDsTest;
import net.hus.core.model.Lookup;
import net.hus.core.model.Lookup.Group;

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

    Lookup l1 = lookup(group, "Sunday", "Sun", 2);
    Lookup l2 = lookup(group, "Monday", "Mon", 4);
    Lookup l3 = lookup(group, "Tuesday", "Tue", 6);
    Lookup l4 = lookup(group, "Wednesday", "Wed", 8);
    Lookup l5 = lookup(group, "Thursday", "Thu", 10);
    Lookup l6 = lookup(group, "Friday", "Fri", 12);
    Lookup l7 = lookup(group, "Saturday", "Sat", 14);

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

    Lookup l1 = lookup(group, "January", "Jan", 1);
    Lookup l2 = lookup(group, "February", "Feb", 2);
    Lookup l3 = lookup(group, "March", "Mar", 3);
    Lookup l4 = lookup(group, "April", "Apr", 4);
    Lookup l5 = lookup(group, "May", "May", 5);
    Lookup l6 = lookup(group, "June", "Jun", 6);
    Lookup l7 = lookup(group, "July", "Jul", 7);
    Lookup l8 = lookup(group, "August", "Aug", 8);
    Lookup l9 = lookup(group, "September", "Sep", 9);
    Lookup l10 = lookup(group, "October", "Oct", 10);
    Lookup l11 = lookup(group, "November", "Nov", 11);
    Lookup l12 = lookup(group, "December", "Dec", 12);

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

    Lookup l1 = lookup(group, "Male", "M", 1);
    Lookup l2 = lookup(group, "Female", "F", 2);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);
    list.add(l2);

    mSql.upsert(list);

    Assert.assertEquals(2, mSql.select(group.name()).size());
  }

  @Test
  public void setupUnknown()
  {
    Group group = Group.UNKNOWN;

    Lookup l1 = lookup(group, "Unknown", "U", 999);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);

    mSql.upsert(list);

    Assert.assertEquals(1, mSql.select(group.name()).size());
  }

  @Test
  public void setupYesNo()
  {
    Group group = Group.YESNO;

    Lookup l1 = lookup(group, "Yes", "Y", 1);
    Lookup l2 = lookup(group, "No", "N", 2);

    List<Lookup> list = new ArrayList<>();
    list.add(l1);
    list.add(l2);

    mSql.upsert(list);

    Assert.assertEquals(2, mSql.select(group.name()).size());
  }

  private Lookup lookup(Group inGroup, String inName, String inAbbr, int inSort)
  {
    Lookup ret = new Lookup();
    ret.setGroup(inGroup);
    ret.setName(inName);
    ret.setAbbreviation(inAbbr);
    ret.setSort(inSort);
    return ret;
  }
}