package net.hus.core.dao.jdbc;

import static net.hus.core.shared.model.Field.Fid.BIRTH_DATE;
import static net.hus.core.shared.model.Field.Fid.EMAIL;
import static net.hus.core.shared.model.Field.Fid.FIELD;
import static net.hus.core.shared.model.Field.Fid.FIRST_NAME;
import static net.hus.core.shared.model.Field.Fid.GENDER;
import static net.hus.core.shared.model.Field.Fid.LAST_NAME;
import static net.hus.core.shared.model.Field.Fid.MIDDLE_NAME;
import static net.hus.core.shared.model.Field.Fid.PAGE;
import static net.hus.core.shared.model.Field.Fid.PASSWORD;
import static net.hus.core.shared.model.Field.Fid.PROFILE;
import static net.hus.core.shared.model.Field.Fid.USERNAME;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.ProfileParser;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.Array;
import net.hus.core.shared.model.Field.Fid;
import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.shared.model.Fields;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.Lookup.Group;
import net.hus.core.shared.model.Page;
import net.hus.core.shared.model.Page.Layout;
import net.hus.core.shared.model.Page.Section;
import net.hus.core.shared.model.Profile;
import net.hus.core.shared.util.StringUtil;
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
  public void quickTest()
  {
    // Fields f = mJdbc.fields("+G$FI$W");
  }

  @Test
  public void appfields()
  {
    List<Field> list = new ArrayList<>();
    list.add(newField(USERNAME, "User Name", "UserNme", null, null));
    list.add(newField(PASSWORD, "Password", "Pswd", null, null));
    list.add(newField(PAGE, "Page", "Page", page(), null));
    list.add(newField(FIRST_NAME, "First name", "First", null, null));
    list.add(newField(LAST_NAME, "Last name", "Last", null, null));
    list.add(newField(MIDDLE_NAME, "Middle name", "Middle", null, null));
    list.add(newField(GENDER, "Gender", "Sex", gender(), null));
    list.add(newField(PROFILE, "Profile", "User", profile(), null));
    list.add(newField(FIELD, "eMail", "eMail", field(), null));
    list.add(newField(EMAIL, "Field", "FLD", null, null));
    list.add(newField(BIRTH_DATE, "Birth", "Dob", null, null));
    list.add(newField(Fid.FIELD_TABLE, "Table", "TBL", fields(), null));

    mJdbc.fields().upsertapp(list);

    for (Field value : list)
    {
      Field field = mJdbc.fields().select(value.getName(), value.getType());
      Assert.assertEquals(field.getId(), field.getId());
    }
  }

  @Test
  public void apptable_person()
  {
    Fields fields = new Fields();
    fields.setFields(new ArrayList<Field>());

    fields.fgg(Field.Table.PERSON.name());
    fields.add(new Field(Field.Fid.FIRST_NAME.fid()));
    fields.add(new Field(Field.Fid.LAST_NAME.fid()));
    fields.add(new Field(Field.Fid.MIDDLE_NAME.fid()));
    fields.add(new Field(Field.Fid.EMAIL.fid()));
    fields.add(new Field(Field.Fid.BIRTH_DATE.fid()));
    fields.add(new Field(Field.Fid.GENDER.fid()));
    // fields.add(new Field(13L)); // address
    fields.add(new Field(Field.Fid.PROFILE.fid()));
    fields.add(new Field(Field.Fid.FIELD.fid()));
    fields.add(new Field(Field.Fid.FIELD_TABLE.fid()));
    // fields.add(new Field(20L)); // suffix
    fields.add(new Field(Field.Fid.PAGE.fid()));
    // fields.add(new Field(23L)); // accounts
    // fields.add(new Field(24L)); // color
    mJdbc.fields().upsert(fields);

    List<Field> ret = mJdbc.fields().selectByFgg(fields.fgg());
    Assert.assertEquals(fields.getFields().size(), ret.size());
  }

  @Test
  public void apptable_login()
  {
    Fields fields = new Fields();
    fields.setFields(new ArrayList<Field>());

    fields.fgg("LOGIN");
    fields.clear();
    fields.add(new Field(Field.Fid.USERNAME.fid()));
    fields.add(new Field(Field.Fid.PASSWORD.fid()));
    mJdbc.fields().upsert(fields);

    List<Field> ret = mJdbc.fields().selectByFgg(fields.fgg());
    Assert.assertEquals(fields.getFields().size(), ret.size());
  }

  @Test
  public void apptable_junit()
  {
    Fields fields = new Fields();
    fields.setFields(new ArrayList<Field>());

    fields.fgg("JUNIT");
    fields.clear();
    fields.add(new Field(Field.Fid.FIRST_NAME.fid()));
    mJdbc.fields().upsert(fields);

    List<Field> ret = mJdbc.fields().selectByFgg(fields.fgg());
    Assert.assertEquals(fields.getFields().size(), ret.size());
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
  public void lookup2lookup()
  {
    mJdbc.lookup2lookup();
    Assert.assertTrue(true); // no fail
  }

  @Test
  public void component2lookup()
  {
    mJdbc.component2lookup();
    Assert.assertTrue(true); // no fail
  }

  @Test
  public void components2lookup()
  {
    mJdbc.components2lookup();
    Assert.assertTrue(true); // no fail
  }

  @Test
  public void setupDaysOfWeek()
  {
    String group = "DAYSOFWEEK";

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
    String group = "MONTHSOFYEAR";

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
  public void setupCommand()
  {
    Group group = Group.COMMAND;

    List<Lookup> list = new ArrayList<>();
    list.add(lookup(group, "LoginCommand", "Login", 1, null));
    list.add(lookup(group, "PageCommand", "Page", 2, null));

    lookup(group, list, 2);
  }

  @Test
  public void setupLayout()
  {
    Group group = Group.LAYOUT;

    List<Lookup> list = new ArrayList<>();
    Assert.assertEquals(4, Page.Layout.values().length);
    for (Layout value : Page.Layout.values())
    {
      list.add(lookup(group, value));

    }
    lookup(group, list, 4);
  }

  @Test
  @Ignore
  public void setupSection()
  {
    Group group = Group.SECTION;

    List<Lookup> list = new ArrayList<>();
    list.add(lookup(group, Section.Name.LEFT_01));
    list.add(lookup(group, Section.Name.LEFT_02));
    list.add(lookup(group, Section.Name.LEFT_03));
    list.add(lookup(group, Section.Name.LEFT_04));
    list.add(lookup(group, Section.Name.LEFT_05));

    list.add(lookup(group, Section.Name.CENTER_01));
    list.add(lookup(group, Section.Name.CENTER_02));
    list.add(lookup(group, Section.Name.CENTER_03));
    list.add(lookup(group, Section.Name.CENTER_04));
    list.add(lookup(group, Section.Name.CENTER_05));

    list.add(lookup(group, Section.Name.RIGHT_01));
    list.add(lookup(group, Section.Name.RIGHT_02));
    list.add(lookup(group, Section.Name.RIGHT_03));
    list.add(lookup(group, Section.Name.RIGHT_04));
    list.add(lookup(group, Section.Name.RIGHT_05));

    lookup(group, list, 15);
  }

  @Test
  public void setupFVT()
  {
    mJdbc.table2lookup();
  }

  @Test
  public void setupcLOGIN()
  {
    component("cLOGIN", "Login page", "cLOGIN.xml");
  }

  @Test
  public void setupcLAND()
  {
    component("cLAND", "Landing page", "cLAND.xml");
  }

  @Test
  public void setupcADMIN()
  {
    component("cADMIN", "Admin page", "cADMIN.xml");
  }

  @Test
  public void setupcHOME()
  {
    component("cHOME", "Home page", "cHOME.xml");
  }

  private void component(String inName, String inDisplay, String inResource)
  {
    String xl = ResourceUtil.contents(inResource);

    Lookup l1 = new Lookup();
    l1.setGroup(Group.COMPONENTS);
    l1.setCode(inName);

    l1.setDisplay(inDisplay);
    l1.setXL(xl);

    lookupXL(xl, l1, l1.getGroup(), l1.getCode());
  }

  @Test
  public void setuppLOGIN()
  {
    String xl = ResourceUtil.contents("pLOGIN.xml");

    Lookup l1 = new Lookup();
    l1.setGroup(Group.PROFILE);
    l1.setCode("pLOGIN");

    l1.setDisplay("Login Profile");
    l1.setXL(xl);

    lookupXL(xl, l1, l1.getGroup(), l1.getCode());
  }

  @Test
  public void setuppADMIN()
  {
    String xl = ResourceUtil.contents("pADMIN.xml");

    Lookup l1 = new Lookup();
    l1.setGroup(Group.PROFILE);
    l1.setCode("pADMIN");

    l1.setDisplay("Admin Profile");
    l1.setXL(xl);

    lookupXL(xl, l1, l1.getGroup(), l1.getCode());
  }

  @Test
  public void setuppHOME()
  {
    String xl = ResourceUtil.contents("pHOME.xml");

    Lookup l1 = new Lookup();
    l1.setGroup(Group.PROFILE);
    l1.setCode("pHOME");

    l1.setDisplay("Home Profile");
    l1.setXL(xl);

    lookupXL(xl, l1, l1.getGroup(), l1.getCode());
  }

  @Test
  public void setupProfiles()
  {
    profile(ResourceUtil.contents("Profile3.xml"));
    profile(ResourceUtil.contents("Profile6.xml"));
    profile(ResourceUtil.contents("Profile7.xml"));
    profile(ResourceUtil.contents("Profile8.xml"));
    profile(ResourceUtil.contents("Profile9.xml"));

    Assert.assertEquals(5, mJdbc.lookups().select(Field.Table.PERSON.name()).size());
  }

  private void profile(String inXml)
  {
    ProfileParser parser = new ProfileParser();
    Profile p = parser.fromXml(inXml);

    Lookup l1 = new Lookup();
    l1.setGroup(Group.PROFILE);
    l1.setCode(p.getUserName());

    l1.setDisplay(p.getName());
    l1.setXL(inXml);

    lookupXL(inXml, l1, l1.getGroup(), l1.getCode());

    List<Lookup> list = new ArrayList<>();
    list.add(lookup(Field.Table.PERSON.name(), p.getUserName(), p.getName(), p.getFirst(), 0, null,
        p.getId()));
    mJdbc.lookups().upsert(list);
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
    lookup(inGroup.name(), inList, inExpectedSize);
  }

  private void lookup(String inGroup, List<Lookup> inList, int inExpectedSize)
  {
    mJdbc.lookups().upsert(inList);
    Assert.assertEquals(inExpectedSize, mJdbc.lookups().select(inGroup).size());
  }

  private Lookup lookup(Group inGroup, Enum<?> inName)
  {
    return lookup(inGroup.name(), inName.name().toUpperCase(),
        StringUtil.toTitle(inName.name().replaceAll("_", " ")), null, 0, null, null);
  }

  private Lookup lookup(Group inGroup, String inName, String inAbbr, int inSort, String inDesc)
  {
    return lookup(inGroup.name(), inName, inAbbr, inSort, inDesc);
  }

  private Lookup lookup(String inGroup, String inName, String inAbbr, int inSort, String inDesc)
  {
    return lookup(inGroup, inName.toUpperCase(), inName, inAbbr, inSort, inDesc, null);
  }

  private Lookup lookup(Group inGroup, String inName, String inDisplay, String inAbbr, int inSort,
      String inDesc)
  {
    return lookup(inGroup.name(), inName, inDisplay, inAbbr, inSort, inDesc, null);
  }

  private Lookup lookup(String inGroup, String inName, String inDisplay, String inAbbr, int inSort,
      String inDesc, Long inAltId)
  {
    Lookup ret = new Lookup();
    ret.setGroup(inGroup);
    ret.setCode(inName);

    ret.setDisplay(inDisplay);
    ret.setAbbreviation(inAbbr);
    ret.setDescription(inDesc);
    ret.setSort(inSort);
    ret.setAltId(inAltId);
    return ret;
  }

  private Field.Lookup gender()
  {
    return new Field.Lookup(Location.TABLE, "BLANK,GENDER,UNKNOWN,");
  }

  private Field.Lookup profile()
  {
    return new Field.Lookup(Location.RPC, "BLANK,PROFILE,");
  }

  private Field.Lookup page()
  {
    return new Field.Lookup(Location.TABLE, "BLANK,COMPONENTS,");
  }

  private Field.Lookup field()
  {
    return new Field.Lookup(Location.TABLE, "BLANK,FIELD,");
  }

  private Field.Lookup fields()
  {
    return new Field.Lookup(Location.TABLE, "BLANK,TABLE,");
  }

  private Field newField(Fid inFid, String inLong, String inShort, Field.Lookup inLookup,
      Array inArray)
  {
    Field ret = new Field();
    ret.setName(inFid.name());
    ret.setType(inFid.type());
    ret.getProperties().setType(inFid.type());
    ret.getProperties().getDisplay().setLong(inLong);
    ret.getProperties().getDisplay().setShort(inShort);
    ret.setLookup(inLookup);
    ret.setArray(inArray);
    ret.setId(inFid.fid());
    return ret;
  }
}