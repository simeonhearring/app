package net.hus.core.shared.components;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.parser.Typeahead_Parser;
import net.hus.core.shared.model.Field.Lookup;
import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.util.ResourceUtil;

public class Typeahead_Test
{
  private UIObject_ mObject;

  @Before
  public void before()
  {
    mObject = newTypeahead();
  }

  @Test
  public void canSerialize() throws IOException, ClassNotFoundException
  {
    SerializationTest.canSerializeObj(mObject);
  }

  @Test
  public void canParse()
  {
    Typeahead_Parser parser = new Typeahead_Parser();

    Typeahead_ model = Typeahead_Test.newTypeahead();

    String expected = ResourceUtil.contents("net/hus/core/shared/components/Typeahead_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }

  public static Typeahead_ newTypeahead()
  {
    Typeahead_ ret = new Typeahead_();

    // List<TypeaheadOption> options = new ArrayList<>();
    // options.add(new TypeaheadOption()
    // {
    // @Override
    // public String option()
    // {
    // return "Name1";
    // }
    // });
    // ret.setOptions(options);
    Lookup lookup = new Lookup();
    lookup.setLocation(Location.RPC);
    lookup.setParameters("GENDER,UNKNOWN");
    ret.setLookup(lookup);

    ret.setValue("Value");
    ValueBoxBase_Test.initValueBoxBase(ret);

    return ret;
  }
}