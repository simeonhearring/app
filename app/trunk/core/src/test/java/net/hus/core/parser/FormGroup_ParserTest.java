package net.hus.core.parser;

import org.junit.Test;

import junit.framework.Assert;
import net.hus.core.client.ui.FormGroup_;
import net.hus.core.client.ui.FormGroup_Test;
import net.hus.core.util.ResourceUtil;

public class FormGroup_ParserTest
{
  @Test
  public void test()
  {
    FormGroup_Parser parser = new FormGroup_Parser();

    FormGroup_ model = FormGroup_Test.newFormGroup();

    String expected = ResourceUtil.contents("net/hus/core/client/ui/FormGroup_.xml");
    expected = expected.replaceAll("\t", "  ");

    Assert.assertEquals(expected, parser.toXml(model));
  }
}