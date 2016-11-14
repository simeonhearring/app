package net.hus.core.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.ProfileParser;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.model.Profile;
import net.hus.core.util.ResourceUtil;

public class CoreJdbcTest extends MySqlCoreDsTest
{
  private CoreJdbc mJdbc;

  @Before
  public void before()
  {
    mJdbc = new CoreJdbc();
    mJdbc.setDataSource(mDataSource);
  }

  @Test
  public void profile2lookup()
  {
    mJdbc.profile2lookup();
    Assert.assertTrue(true); // no fail
  }

  @Test
  public void field2lookup()
  {
    mJdbc.field2lookup();
    Assert.assertTrue(true); // no fail
  }

  @Test
  public void fields2lookup()
  {
    mJdbc.fields2lookup();
    Assert.assertTrue(true); // no fail
  }

  @Test
  public void component2lookup()
  {
    mJdbc.component2lookup();
    Assert.assertTrue(true); // no fail
  }

  @Test
  public void setupDaysOfWeek()
  {
    Group group = Group.DAYSOFWEEK;

    List<Lookup> list = new ArrayList<>();
    list.add(lookup(group, "Sunday", "Sun", 2, null));
    list.add(lookup(group, "Monday", "Mon", 4, null));
    list.add(lookup(group, "Tuesday", "Tue", 6, null));
    list.add(lookup(group, "Wednesday", "Wed", 8, null));
    list.add(lookup(group, "Thursday", "Thu", 10, null));
    list.add(lookup(group, "Friday", "Fri", 12, null));
    list.add(lookup(group, "Saturday", "Sat", 14, null));

    lookup(group, list, 7);
  }

  @Test
  public void setupMonthsOfYear()
  {
    Group group = Group.MONTHSOFYEAR;

    List<Lookup> list = new ArrayList<>();
    list.add(lookup(group, "January", "Jan", 1, null));
    list.add(lookup(group, "February", "Feb", 2, null));
    list.add(lookup(group, "March", "Mar", 3, null));
    list.add(lookup(group, "April", "Apr", 4, null));
    list.add(lookup(group, "May", "May", 5, null));
    list.add(lookup(group, "June", "Jun", 6, null));
    list.add(lookup(group, "July", "Jul", 7, null));
    list.add(lookup(group, "August", "Aug", 8, null));
    list.add(lookup(group, "September", "Sep", 9, null));
    list.add(lookup(group, "October", "Oct", 10, null));
    list.add(lookup(group, "November", "Nov", 11, null));
    list.add(lookup(group, "December", "Dec", 12, null));

    lookup(group, list, 12);
  }

  @Test
  public void setupGender()
  {
    Group group = Group.GENDER;

    List<Lookup> list = new ArrayList<>();
    list.add(lookup(group, "Male", "M", 1, null));
    list.add(lookup(group, "Female", "F", 2, null));

    lookup(group, list, 2);
  }

  @Test
  public void setupBlank()
  {
    Group group = Group.BLANK;

    List<Lookup> list = new ArrayList<>();
    list.add(lookup(group, "BLANK", "(Select One)", "", 0, null));

    lookup(group, list, 1);
  }

  @Test
  public void setupUnknown()
  {
    Group group = Group.UNKNOWN;

    List<Lookup> list = new ArrayList<>();
    list.add(lookup(group, "Unknown", "U", 999, null));

    lookup(group, list, 1);
  }

  @Test
  public void setupYesNo()
  {
    Group group = Group.YESNO;

    List<Lookup> list = new ArrayList<>();
    list.add(lookup(group, "Yes", "Y", 1, null));
    list.add(lookup(group, "No", "N", 2, null));

    lookup(group, list, 2);
  }

  @Test
  public void setupTables()
  {
    Group group = Group.TABLE;

    List<Lookup> list = new ArrayList<>();
    list.add(lookup(group, "Junit", "JT", 1, "Used for junit testing"));
    list.add(lookup(group, "Person", "PER", 2, "Used to store person information."));

    lookup(group, list, 2);
  }

  @Test
  public void setupComponents1()
  {
    String xl = ResourceUtil.contents("Components1.xml");

    Lookup l1 = new Lookup();
    l1.setGroup(Group.COMPONENTS);
    l1.setName("Components1");

    l1.setDisplay("Login");
    l1.setXL(xl);

    lookupXL(xl, l1, l1.getGroup(), l1.getName());
  }

  @Test
  public void setupComponents2()
  {
    String xl = ResourceUtil.contents("Components2.xml");

    Lookup l1 = new Lookup();
    l1.setGroup(Group.COMPONENTS);
    l1.setName("Components2");

    l1.setDisplay("Landing page");
    l1.setXL(xl);

    lookupXL(xl, l1, l1.getGroup(), l1.getName());
  }

  @Test
  public void setupProfile0()
  {
    String xl = ResourceUtil.contents("Profile0.xml");

    Lookup l1 = new Lookup();
    l1.setGroup(Group.APP_PROFILE);
    l1.setName("login");

    l1.setDisplay("Login Profile");
    l1.setXL(xl);

    lookupXL(xl, l1, l1.getGroup(), l1.getName());
  }

  @Test
  public void setupProfile3()
  {
    profile(ResourceUtil.contents("Profile3.xml"));
  }

  @Test
  public void setupProfile6()
  {
    profile(ResourceUtil.contents("Profile6.xml"));
  }

  @Test
  public void setupProfile7()
  {
    profile(ResourceUtil.contents("Profile7.xml"));
  }

  @Test
  public void setupProfile8()
  {
    profile(ResourceUtil.contents("Profile8.xml"));
  }

  @Test
  public void setupProfile9()
  {
    profile(ResourceUtil.contents("Profile9.xml"));
  }

  private void profile(String inXml)
  {
    ProfileParser parser = new ProfileParser();
    Profile p = parser.fromXml(inXml);

    Lookup l1 = new Lookup();
    l1.setGroup(Group.PROFILE);
    l1.setName(p.getUserName());

    l1.setDisplay(p.getName());
    l1.setXL(inXml);

    lookupXL(inXml, l1, l1.getGroup(), l1.getName());
  }

  private void lookupXL(String inXL, Lookup inLookup, String inGroup, String inName)
  {
    List<Lookup> list = new ArrayList<>();
    list.add(inLookup);

    mJdbc.lookups().upsertXL(list);
    Assert.assertEquals(inGroup, mJdbc.lookups().selectXL(inGroup).get(0).getGroup());
    Assert.assertEquals(inXL, mJdbc.lookups().selectXL(inGroup, inName).getXL());
  }

  private void lookup(Group inGroup, List<Lookup> inList, int inExpectedSize)
  {
    mJdbc.lookups().upsert(inList);
    Assert.assertEquals(inExpectedSize, mJdbc.lookups().select(inGroup.name()).size());
  }

  private Lookup lookup(Group inGroup, String inName, String inAbbr, int inSort, String inDesc)
  {
    return lookup(inGroup, inName.toUpperCase(), inName, inAbbr, inSort, inDesc);
  }

  private Lookup lookup(Group inGroup, String inName, String inDisplay, String inAbbr, int inSort,
      String inDesc)
  {
    Lookup ret = new Lookup();
    ret.setGroup(inGroup);
    ret.setName(inName);

    ret.setDisplay(inDisplay);
    ret.setAbbreviation(inAbbr);
    ret.setDescription(inDesc);
    ret.setSort(inSort);
    return ret;
  }
}